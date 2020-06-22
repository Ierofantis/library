package com.library.search.controller;

import com.library.search.model.Album;
import com.library.search.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;

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
        return "import";
    }

    @GetMapping("/view")
    public String view(){
        System.out.println("view");
        return "view";
    }
}
