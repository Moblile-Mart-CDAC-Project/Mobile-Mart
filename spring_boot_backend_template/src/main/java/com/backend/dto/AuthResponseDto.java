package com.backend.dto;





import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDto {
	private Long userId;
    private String token;
    private String role;
}

