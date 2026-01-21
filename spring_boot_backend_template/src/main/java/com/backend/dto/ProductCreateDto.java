package com.backend.dto;



import jakarta.validation.constraints.*;
import lombok.*;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class ProductCreateDto {
//
//    @NotBlank
//    private String name;
//
//    @NotNull
//    @Positive
//    private Double price;
//
//    @NotBlank
//    private String category;
//}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDto {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @NotNull
    @Min(value = 0, message = "Stock quantity cannot be negative")
    private Integer stockQuantity;
}

