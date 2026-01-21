package com.backend.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entitys.Product;
import com.backend.entitys.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    List<ProductImage> findByProduct(Product product);
}
