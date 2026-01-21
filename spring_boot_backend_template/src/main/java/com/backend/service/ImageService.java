package com.backend.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    List<String> uploadProductImages(Long productId, MultipartFile[] files);

    void deleteImage(Long imageId);
}
