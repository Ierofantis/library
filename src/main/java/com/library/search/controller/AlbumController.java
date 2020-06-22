package com.library.search.controller;

import com.library.search.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/lib")
public class AlbumController {

//    @Autowired
//    private AlbumService albumService;

    @PostMapping("/import")
    public String response() {
        System.out.println("import");
        return "import";
    }

    @GetMapping("/view")
    public String view(){
        System.out.println("view");
        return "view";
    }
}
