package com.galaxyware.colaborae.controller;

import com.galaxyware.colaborae.model.UserModel;
import com.galaxyware.colaborae.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping()
    public ResponseEntity<UserModel> newUser(@RequestBody UserModel newUser){
        //Todo - Refatorar. só fiz para testar
        UserModel save = userRepository.save(newUser);
        return ResponseEntity.ok().body(save);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity deleteUser(@PathVariable UUID uuid){
        //Todo - Refatorar. só fiz para testar
        userRepository.deleteById(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}