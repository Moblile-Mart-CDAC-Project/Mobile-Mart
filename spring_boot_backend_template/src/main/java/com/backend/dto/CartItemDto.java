package com.backend.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private Long cartItemId;
    private Long productId;
    private String productName;
    private int quantity;
    private double price;
}
