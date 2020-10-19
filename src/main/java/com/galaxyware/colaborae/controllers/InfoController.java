package com.galaxyware.colaborae.controllers;

import com.galaxyware.colaborae.models.InfoAPIModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/")
    public ResponseEntity infos(){
        return ResponseEntity.status(HttpStatus.OK).body(new InfoAPIModel("Colaborae", "0.1"));
    }
}
