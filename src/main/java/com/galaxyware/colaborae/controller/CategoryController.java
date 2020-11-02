package com.galaxyware.colaborae.controller;

import com.galaxyware.colaborae.model.CategoryModel;
import com.galaxyware.colaborae.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    @GetMapping(value = "/{uuid}")
    public CategoryModel findById(UUID uuid) {
        Optional<CategoryModel> obj = categoryRepository.findById(uuid);
        return obj.get();
    }

    @PostMapping()
    public ResponseEntity<CategoryModel> insert(@RequestBody CategoryModel obj) {

        CategoryModel save = categoryRepository.save(obj);
        return ResponseEntity.ok().body(save);
    }
    @GetMapping(value = "nome/{name}")
    public CategoryModel findByName(@PathVariable String name) {
        CategoryModel obj = categoryRepository.findByName(name);
        return obj;
    }

}
