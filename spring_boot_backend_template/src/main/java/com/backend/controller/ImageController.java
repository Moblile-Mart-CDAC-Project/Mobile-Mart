package com.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.backend.service.ImageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/images")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class ImageController {

    private final ImageService imageService;

    // upload 4–5 images
    @PostMapping("/upload/{productId}")
    public ResponseEntity<List<String>> uploadImages(
            @PathVariable Long productId,
            @RequestParam("files") MultipartFile[] files) {

        return ResponseEntity.ok(
                imageService.uploadProductImages(productId, files)
        );
    }

    // delete single image
    @DeleteMapping("/{imageId}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long imageId) {

        imageService.deleteImage(imageId);
        return ResponseEntity.noContent().build();
    }
}
