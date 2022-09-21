package com.testapp.ecommerce.controller.impl;

import com.testapp.ecommerce.controller.CategoryController;
import com.testapp.ecommerce.model.response.CategoryDTO;
import com.testapp.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CategoryControllerImpl implements CategoryController {
    @Autowired
    CategoryService categoryService;

    @Override
    public ResponseEntity<CategoryDTO> addCategory(CategoryDTO categoryRequestDTO) throws Exception {
        return categoryService.saveCategory(categoryRequestDTO);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> getAll() {
        return categoryService.getAllCategories();
    }

    @Override
    public ResponseEntity<CategoryDTO> getCategoryById(Integer id) {
        return categoryService.getCategoryById(id);
    }
}
