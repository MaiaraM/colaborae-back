package com.galaxyware.colaborae.controller;
import com.galaxyware.colaborae.business.CategoryBo;
import com.galaxyware.colaborae.model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryBo categoryBo;            

    @GetMapping()
    public ResponseEntity<Page<CategoryModel>> getAll(@PageableDefault(page = 0, size = 12) Pageable pageable) {
        Page<CategoryModel> category =  categoryBo.findAllCategories(pageable);
        return ResponseEntity.ok().body(category);
    }

<<<<<<< HEAD
    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryModel> findByName(@PathVariable String name) {
        CategoryModel category =  categoryBo.findByName(name);
        return category != null ? ResponseEntity.ok().body(category) : ResponseEntity.notFound().build() ;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CategoryModel> findById(@PathVariable UUID uuid) {
        CategoryModel category =  categoryBo.findCategoryByUuid(uuid);
        return category != null ? ResponseEntity.ok().body(category) : ResponseEntity.notFound().build() ;
    }


    @PostMapping()
    public ResponseEntity<CategoryModel> insert(@RequestBody CategoryModel category) {
        CategoryModel newCategory =  categoryBo.saveNewCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

   @PutMapping("/{uuid}")
    public ResponseEntity<CategoryModel> edit(@PathVariable UUID uuid, @RequestBody CategoryModel category) {
        CategoryModel updateCategory =  categoryBo.updateCategory(uuid,category);
        return ResponseEntity.ok().body(updateCategory);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<CategoryModel> delete(@PathVariable UUID uuid) {
         categoryBo.deleteCategory(uuid);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
=======
    @GetMapping()
    public ResponseEntity<Page<CategoryModel>> getAll(@PageableDefault(page = 0, size = 12) Pageable pageable) {
        Page<CategoryModel> category = categoryRepository.findAll(pageable);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryModel> findByName(@PathVariable String name) {
        CategoryModel category = categoryRepository.findByName(name);
        return category != null ? ResponseEntity.ok().body(category) : ResponseEntity.notFound().build() ;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CategoryModel> findById(@PathVariable UUID uuid) {
        CategoryModel category = categoryRepository.findById(uuid).orElse(null);
        return category != null ? ResponseEntity.ok().body(category) : ResponseEntity.notFound().build() ;
    }


    @PostMapping()
    public ResponseEntity<CategoryModel> insert(@RequestBody CategoryModel category) {
        CategoryModel newCategory = categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

//    @PutMapping("/{uuid}")
//    public ResponseEntity<CategoryModel> edit(@PathVariable UUID uuid, @RequestBody CategoryModel category) {
//        CategoryModel newCategory = categoryRepository.save(category);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
//    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<CategoryModel> delete(@PathVariable UUID uuid) {
        categoryRepository.deleteById(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
>>>>>>> main
    }

}
