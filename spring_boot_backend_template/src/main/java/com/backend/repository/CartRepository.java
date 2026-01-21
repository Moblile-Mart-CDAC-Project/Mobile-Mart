package com.backend.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entitys.Cart;
import com.backend.entitys.User;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUser(User user);

//    Optional<Cart> findByUserEmail(String email);
}
