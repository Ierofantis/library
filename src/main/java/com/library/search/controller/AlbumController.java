package com.library.search.controller;

import com.library.search.model.Album;
import com.library.search.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/view/all")
    public List<Album> view(){
        System.out.println("view");
        return albumService.findAll();
    }

    @GetMapping("/view")
    @ResponseBody
    public  Optional<List<Album>> getData(@RequestParam String artist, @RequestParam(required = false) String name ) {
        return albumService.findByArtistOrName(artist,name);
    }
}
