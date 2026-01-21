package com.backend.dto;



import lombok.*;

@Data

public class OrderDto {

    private Long orderId;
    private String status;
    private Double totalAmount;
    
}
