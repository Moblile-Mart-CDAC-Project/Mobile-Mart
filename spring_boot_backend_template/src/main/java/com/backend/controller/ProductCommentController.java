package com.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.AddCommentDto;
import com.backend.dto.CommentResponseDto;
import com.backend.service.ProductCommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products/{productId}/comments")
@RequiredArgsConstructor
public class ProductCommentController {

    private final ProductCommentService commentService;

    // USER adds comment
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> addComment(
            @PathVariable Long productId,
            @Valid @RequestBody AddCommentDto dto) {

        commentService.addComment(productId, dto);
        return ResponseEntity.ok().build();
    }

    // PUBLIC: view comments
    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getComments(
            @PathVariable Long productId) {

        return ResponseEntity.ok(commentService.getComments(productId));
    }
}
