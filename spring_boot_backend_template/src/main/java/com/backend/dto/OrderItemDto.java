package com.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {

    private Long productId;
    private String productName;
    private Double price;
    private Integer quantity;
}
