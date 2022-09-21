package com.testapp.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface AddProductController {

    @PostMapping("/addProduct")
    ResponseEntity<String> getProductName(Integer productId);
}
