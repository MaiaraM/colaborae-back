package com.galaxyware.colaborae.business;

import com.galaxyware.colaborae.model.CategoryModel;
import com.galaxyware.colaborae.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryBo {

    @Autowired
    CategoryRepository categoryRepository;

    public Page<CategoryModel> findAllCategories(Pageable pageable) { return categoryRepository.findAll(pageable); }

    public CategoryModel findCategoryByUuid(UUID uuid) { return categoryRepository.findById(uuid).orElse(null); }

    public CategoryModel findByName(String name){return categoryRepository.findByName(name);}

    public CategoryModel saveNewCategory(CategoryModel categoryModel) { return categoryRepository.save(categoryModel); }

    public CategoryModel updateCategory(UUID uuid, CategoryModel categoryModel) {
        CategoryModel  categoryByUuid = findCategoryByUuid(uuid);

         categoryByUuid.setName(categoryModel.getName());
         categoryByUuid.setDescricao(categoryModel.getDescricao());
         categoryByUuid.setActive(categoryModel.getActive());

        return categoryRepository.save( categoryByUuid);
    }

    public void deleteCategory(UUID uuid) {
        categoryRepository.deleteById(uuid);
    }
}
