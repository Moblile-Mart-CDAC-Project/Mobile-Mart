package com.backend.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsDto {

    private Long orderId;
    private Double totalAmount;
    private String status;
    private List<OrderItemDto> items;
}

