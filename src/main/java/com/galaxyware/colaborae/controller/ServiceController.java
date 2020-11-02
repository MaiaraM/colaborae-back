package com.galaxyware.colaborae.controller;

import com.galaxyware.colaborae.model.ServiceModel;
import com.galaxyware.colaborae.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping(value = "/{tittle}")
    public ResponseEntity<ServiceModel> findById(@PathVariable String title) {
        ServiceModel obj=serviceRepository.findByTitle(title);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping()
    public ResponseEntity<ServiceModel> insert(@RequestBody ServiceModel obj) {

        ServiceModel save = serviceRepository.save(obj);
        return ResponseEntity.ok().body(save);
    }


}
