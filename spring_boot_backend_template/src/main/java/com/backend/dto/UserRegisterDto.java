package com.backend.dto;





import jakarta.validation.constraints.*;
import lombok.*;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserRegisterDto {
//
//    @NotBlank(message = "Name is required")
//    private String name;
//
//    @Email
//    @NotBlank
//    private String email;
//
//    @Size(min = 6, message = "Password must be at least 6 characters")
//    private String password;
//    
//
//    @NotBlank
//    private String mobile;
//}




import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Mobile is required")
    private String mobile;
}

