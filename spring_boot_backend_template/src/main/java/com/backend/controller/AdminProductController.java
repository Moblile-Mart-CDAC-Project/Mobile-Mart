package com.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.backend.dto.ProductCreateDto;
import com.backend.dto.ProductDto;
import com.backend.dto.ProductUpdateDto;
import com.backend.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/products")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminProductController {

    private final ProductService productService;

    // ===============================
    // ADD PRODUCT (ADMIN)
    // ===============================
    @PostMapping
    public ResponseEntity<ProductDto> addProduct(
            @Valid @RequestBody ProductCreateDto dto) {

        return ResponseEntity.ok(productService.addProduct(dto));
    }

    // ===============================
    // GET MY PRODUCTS (ADMIN)
    // ===============================
    @GetMapping
    public ResponseEntity<List<ProductDto>> myProducts() {

        return ResponseEntity.ok(productService.getMyProducts());
    }

    // ===============================
    // UPDATE PRODUCT (ADMIN)
    // ===============================
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable Long productId,
            @Valid @RequestBody ProductUpdateDto dto) {

        return ResponseEntity.ok(
                productService.updateProduct(productId, dto)
        );
    }

    // ===============================
    // DELETE PRODUCT (ADMIN)
    // ===============================
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long productId) {

        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}





