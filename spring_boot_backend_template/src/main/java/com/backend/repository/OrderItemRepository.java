package com.backend.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.backend.dto.OrderDto;
import com.backend.entitys.Order;
import com.backend.entitys.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

//	   OrderDto placeOrder();
//
//	    List<OrderDto> myOrders();
//
//	    OrderDto orderDetails(Long orderId);
	 List<OrderItem> findByOrder(Order order);
}
