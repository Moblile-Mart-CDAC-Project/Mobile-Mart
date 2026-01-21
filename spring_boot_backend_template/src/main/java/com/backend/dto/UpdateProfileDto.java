package com.backend.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
//public class UserUpdateDto {
//
//    @NotBlank(message = "Name cannot be empty")
//    private String name;
//}
public class UpdateProfileDto {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "mobile cannot be empty")
    private String mobile;
}

