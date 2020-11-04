package com.galaxyware.colaborae.controller;

import com.galaxyware.colaborae.model.InfoAPIModel;
<<<<<<< HEAD
=======
import org.springframework.http.HttpStatus;
>>>>>>> main
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/")
    public ResponseEntity infos(){
        return ResponseEntity.ok().body(new InfoAPIModel("Colaborae", "0.1"));
    }
}
