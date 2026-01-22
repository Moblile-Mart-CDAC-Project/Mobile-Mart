package com.backend.service;

import java.util.List;

import com.backend.dto.AddCommentDto;
import com.backend.dto.CommentResponseDto;

public interface ProductCommentService {

    void addComment(Long productId, AddCommentDto dto);

    List<CommentResponseDto> getComments(Long productId);
}
