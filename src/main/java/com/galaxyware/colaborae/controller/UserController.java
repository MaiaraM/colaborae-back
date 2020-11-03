package com.galaxyware.colaborae.controller;

import com.galaxyware.colaborae.model.UserModel;
import com.galaxyware.colaborae.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/{uuid}")
    public ResponseEntity<UserModel> findById(@PathVariable UUID uuid) {
        UserModel user =userRepository.findById(uuid).orElse(null);
        return user != null ? ResponseEntity.ok().body(user) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<UserModel> insert(@RequestBody UserModel user) {
        UserModel newUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity deleteUser(@PathVariable UUID uuid){
        userRepository.deleteById(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}


