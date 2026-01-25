package com.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.dto.AddCommentDto;
import com.backend.dto.CommentResponseDto;
import com.backend.entitys.Product;
import com.backend.entitys.ProductComment;
import com.backend.entitys.User;
import com.backend.repository.ProductCommentRepository;
import com.backend.repository.ProductRepository;
import com.backend.repository.UserRepository;
import com.backend.security.SecurityUtil;
import com.backend.service.ProductCommentService;

import org.springframework.lang.NonNull;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCommentServiceImpl
        implements ProductCommentService {

    private final ProductRepository productRepository;
    private final ProductCommentRepository commentRepository;
    private final UserRepository userRepository;

    @Override
    public void addComment(@NonNull Long productId, AddCommentDto dto) {

        User user = userRepository.findByEmail(
                SecurityUtil.getCurrentUserEmail()
        ).orElseThrow();

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductComment comment = new ProductComment();
        comment.setProduct(product);
        comment.setUser(user);
        comment.setComment(dto.getComment());

        commentRepository.save(comment);
    }

    @Override
    public List<CommentResponseDto> getComments(@NonNull Long productId) {

        return commentRepository
                .findByProduct_ProductIdOrderByCreatedAtDesc(productId)
                .stream()
                .map(c -> new CommentResponseDto(
                        c.getCommentId(),
                        c.getComment(),
                        c.getUser().getName(),
                        c.getCreatedAt()
                ))
                .toList();
    }
}
