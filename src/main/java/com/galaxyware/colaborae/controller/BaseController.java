package com.galaxyware.colaborae.controller;

import com.galaxyware.colaborae.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/base")
public class BaseController {
    @Autowired
    BaseRepository baseRepository;

}
