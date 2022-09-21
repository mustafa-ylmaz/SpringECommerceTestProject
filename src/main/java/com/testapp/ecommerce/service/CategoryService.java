package com.testapp.ecommerce.service;

import com.testapp.ecommerce.model.response.CategoryDTO;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;
import java.util.List;


public interface CategoryService {


    ResponseEntity<CategoryDTO> saveCategory(@Valid @RequestBody CategoryDTO categoryRequestDTO) throws Exception;

    ResponseEntity<List<CategoryDTO>> getAllCategories();

    ResponseEntity<CategoryDTO> getCategoryById(Integer id);

}
