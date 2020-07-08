package com.library.search.controller;

import com.library.search.dto.AlbumResponse;
import com.library.search.dto.AlbumValues;
import com.library.search.model.Album;
import com.library.search.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/lib")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping("/import")
    @ResponseBody
    public String addCsv() {
        System.out.println("import");
        albumService.AlbumCreate();
        return "csv imported";
    }

    //?pageSize=5&pageNo=1&sortBy=name
    @GetMapping("/view/all")
    public ResponseEntity<AlbumResponse> view(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy){

        AlbumResponse response = new AlbumResponse();
        List<AlbumValues> list = albumService.findAll(pageNo, pageSize, sortBy).stream().map(e -> {
            AlbumValues dto = new AlbumValues();
            dto.setName(e.getName());
            dto.setArtist(e.getArtist());
            dto.setGender(e.getGender());
            dto.setPrice(e.getPrice());
            return dto;
        }).collect(Collectors.toList());
        response.setData(list);
        return new ResponseEntity<AlbumResponse>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/view")
    @ResponseBody
    public  Optional<List<Album>> getData(@RequestParam String artist, @RequestParam(required = false) String name ) {
        return albumService.findByArtistOrName(artist,name);
    }
}
