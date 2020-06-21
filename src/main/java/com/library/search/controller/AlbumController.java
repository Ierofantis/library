package com.library.search.controller;

import com.library.search.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/lib")
public class AlbumController {

    @Autowired
    private AlbumService albumService;
}
