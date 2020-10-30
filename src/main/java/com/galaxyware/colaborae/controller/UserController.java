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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity<List<UserModel>> findAll() {
        List<UserModel> list = userRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{uuid}")
    public ResponseEntity<UserModel> findById(@PathVariable UUID uuid) {
           Optional<UserModel> obj=userRepository.findById(uuid);
        return ResponseEntity.ok().body(obj.get());
    }

    @PostMapping()
    public ResponseEntity<UserModel> insert(@RequestBody UserModel obj) {

        UserModel save = userRepository.save(obj);
        return ResponseEntity.ok().body(save);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity deleteUser(@PathVariable UUID uuid){
        //Todo - Refatorar. só fiz para testar
        userRepository.deleteById(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
