package com.backend.service;

import org.springframework.lang.NonNull;

import com.backend.dto.AddToCartDto;
import com.backend.dto.CartDto;

//public interface CartService {
//		CartDto addToCart(Long productId, int quantity);
//	    CartDto updateQuantity(Long itemId, int quantity);
//	    CartDto viewCart();
//	    void removeItem(Long itemId);
//	    void clearCart();
//}
public interface CartService {

    CartDto addToCart(@NonNull AddToCartDto dto);

    CartDto viewCart();

    void clearCart();

	CartDto updateCart(@NonNull AddToCartDto dto);
}

