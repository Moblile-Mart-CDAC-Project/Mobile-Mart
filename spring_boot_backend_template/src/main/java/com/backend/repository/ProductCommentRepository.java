package com.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entitys.ProductComment;

public interface ProductCommentRepository
extends JpaRepository<ProductComment, Long> {

List<ProductComment> findByProduct_ProductIdOrderByCreatedAtDesc(Long productId);
}
