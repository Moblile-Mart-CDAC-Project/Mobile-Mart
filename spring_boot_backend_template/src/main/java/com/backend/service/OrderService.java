package com.backend.service;

import java.util.List;

import com.backend.dto.OrderDetailsDto;
import com.backend.dto.OrderDto;

public interface OrderService {
	//user
		OrderDto placeOrder();
	    List<OrderDto> myOrders();
	    OrderDetailsDto orderDetails(Long orderId);
	    
	    // admin
	    List<OrderDto> getAllOrders();
	    OrderDetailsDto getOrderDetailsForAdmin(Long orderId);
}
