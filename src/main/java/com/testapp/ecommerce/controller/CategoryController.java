package com.testapp.ecommerce.controller;


import com.testapp.ecommerce.model.response.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/category")
public interface CategoryController {
    @PostMapping("/addCategory")
    ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO categoryRequestDTO) throws Exception;

    @GetMapping("/getAll")
    ResponseEntity<List<CategoryDTO>> getAll();

    @GetMapping("/category/{id}")
    ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Integer id);

}
