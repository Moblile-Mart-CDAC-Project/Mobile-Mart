package com.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.backend.dto.OrderDto;
import com.backend.dto.OrderDetailsDto;
import com.backend.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/orders")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminOrderController {

    private final OrderService orderService;

    // view all orders
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // view order details
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetailsDto> getOrderDetails(
            @PathVariable Long orderId) {

        return ResponseEntity.ok(
                orderService.getOrderDetailsForAdmin(orderId)
        );
    }
}

