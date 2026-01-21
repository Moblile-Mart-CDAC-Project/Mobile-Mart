package com.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.OrderDetailsDto;
import com.backend.dto.OrderDto;
import com.backend.service.OrderService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@PreAuthorize("hasRole('USER')")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> placeOrder() {
        return ResponseEntity.ok(orderService.placeOrder());
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> myOrders() {
        return ResponseEntity.ok(orderService.myOrders());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetailsDto> orderDetails(
            @PathVariable Long orderId) {

        return ResponseEntity.ok(
                orderService.orderDetails(orderId)
        );
    }

}

