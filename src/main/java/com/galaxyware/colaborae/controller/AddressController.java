package com.galaxyware.colaborae.controller;

import com.galaxyware.colaborae.model.AddressModel;
import com.galaxyware.colaborae.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @PostMapping()
    public ResponseEntity<AddressModel> insert(@RequestBody AddressModel obj) {

        AddressModel save = addressRepository.save(obj);
        return ResponseEntity.ok().body(save);
    }

}
