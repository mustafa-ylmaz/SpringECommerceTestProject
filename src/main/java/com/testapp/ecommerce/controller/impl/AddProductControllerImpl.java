package com.testapp.ecommerce.controller.impl;

import com.testapp.ecommerce.controller.AddProductController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;

@Tag(name="Add Product Controller", description = "Add product api")
@RestController
public class AddProductControllerImpl implements AddProductController {
    @Operation(summary = "Product query with product id")
    @Override
    public ResponseEntity<String> getProductName(Integer productId) {
        return ResponseEntity.ok("test product: "+productId);
    }
}
