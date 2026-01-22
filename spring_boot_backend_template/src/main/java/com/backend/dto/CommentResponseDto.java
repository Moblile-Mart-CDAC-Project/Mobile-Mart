package com.backend.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class CommentResponseDto {
	 private Long commentId;
	    private String comment;
	    private String userName;
	    private LocalDateTime createdAt;
}
