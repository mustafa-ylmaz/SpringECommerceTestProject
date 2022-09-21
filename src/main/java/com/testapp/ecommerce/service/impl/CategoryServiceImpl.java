package com.testapp.ecommerce.service.impl;

import com.testapp.ecommerce.entity.Category;

import com.testapp.ecommerce.model.response.CategoryDTO;
import com.testapp.ecommerce.repository.CategoryRepository;
import com.testapp.ecommerce.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    private final ModelMapper modelMapper;


    @Autowired
    public CategoryServiceImpl(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }


    @Override
    public ResponseEntity<CategoryDTO> saveCategory(CategoryDTO categoryRequestDTO) {
        Category category = modelMapper.map(categoryRequestDTO, Category.class);
        CategoryDTO responseDTO = modelMapper.map(categoryRepository.save(category), CategoryDTO.class);

        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(cat -> modelMapper.map(cat, CategoryDTO.class)).collect(Collectors.toList());
        if(categoryDTOS.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(categoryDTOS);
    }

    @Override
    public ResponseEntity<CategoryDTO> getCategoryById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(modelMapper.map(category, CategoryDTO.class));
    }


}
