package com.galaxyware.colaborae.controller;

import com.galaxyware.colaborae.model.CategoryModel;
import com.galaxyware.colaborae.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/{name}")
    public CategoryModel findById(@PathVariable String name) {
        Optional<CategoryModel> obj = categoryRepository.findByName(name);
        return obj.get();
    }

}
