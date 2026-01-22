package com.backend.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backend.entitys.Product;
import com.backend.entitys.ProductImage;
import com.backend.repository.ProductImageRepository;
import com.backend.repository.ProductRepository;
import com.backend.service.ImageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private static final String IMAGE_DIR =
    		System.getProperty("user.dir") + "/uploads/images/products/";;

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    // ===============================
    // UPLOAD MULTIPLE IMAGEs
    // ===============================
    @Override
    public List<String> uploadProductImages(Long productId, MultipartFile[] files) {
//    	System.out.println("IMAGE UPLOAD SERVICE CALLED");
//    	System.out.println("IMAGE DIR = " + IMAGE_DIR);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        List<String> imageUrls = new ArrayList<>();

        try {
            Files.createDirectories(Paths.get(IMAGE_DIR));

            for (MultipartFile file : files) {

//              String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            	 String extension =
                         file.getOriginalFilename()
                             .substring(file.getOriginalFilename().lastIndexOf("."));

            	String fileName = UUID.randomUUID() + extension;
            	//
            	Path filePath = Paths.get(IMAGE_DIR + fileName);

                Files.write(filePath, file.getBytes());

                String imageUrl =
                        "http://localhost:8080/images/products/" + fileName;

                ProductImage image = new ProductImage();
                image.setProduct(product);
                image.setImageUrl(imageUrl);

                productImageRepository.save(image);
                imageUrls.add(imageUrl);
            }

        } catch (IOException e) {
            throw new RuntimeException("Image upload failed");
        }

        return imageUrls;
    }

    // ===============================
    // DELETE IMAGE (EDIT PRODUCT CASE)
    // ===============================
    @Override
    public void deleteImage(Long imageId) {

        ProductImage image = productImageRepository.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image not found"));

        // delete physical file
        try {
            String fileName = image.getImageUrl()
                    .substring(image.getImageUrl().lastIndexOf("/") + 1);

            Path path = Paths.get(IMAGE_DIR + fileName);
            Files.deleteIfExists(path);

        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image file");
        }

        // delete DB record
        productImageRepository.delete(image);
    }
}
