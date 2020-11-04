package com.galaxyware.colaborae.controller;

import com.galaxyware.colaborae.business.UserBo;
import com.galaxyware.colaborae.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserBo userBo;


    @GetMapping()
    public ResponseEntity<Page<UserModel>> getAll(@PageableDefault(page = 0, size = 12) Pageable pageable) {
        Page< UserModel> users = userBo.findAllUsers(pageable);
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserModel> findById(@PathVariable UUID uuid) {
        UserModel user = userBo.findUserByUuid(uuid);
        return user != null
                ? ResponseEntity.ok().body(user)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserModel>> searchByFirtName(@RequestParam() String name) {
        List<UserModel> user = userBo.findByFirstName(name);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping()
    public ResponseEntity< UserModel> insert(@RequestBody  UserModel userModel) {
        UserModel save = userBo.saveNewUser(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity< UserModel> update(@PathVariable UUID uuid, @RequestBody  UserModel userModel) {
         UserModel updateUser = userBo.updateUser(uuid, userModel);
        return ResponseEntity.ok().body(updateUser);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity< UserModel> delete(@PathVariable UUID uuid) {
        userBo.deleteUser(uuid);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}


