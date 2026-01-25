package com.backend.service;

import org.springframework.lang.NonNull;

import java.util.List;

import com.backend.dto.AddCommentDto;
import com.backend.dto.CommentResponseDto;

public interface ProductCommentService {

    void addComment(@NonNull Long productId, AddCommentDto dto);

    List<CommentResponseDto> getComments(@NonNull Long productId);
}
