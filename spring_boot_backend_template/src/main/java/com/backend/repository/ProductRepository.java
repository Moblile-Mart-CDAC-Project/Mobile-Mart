package com.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.backend.entitys.Product;
import com.backend.entitys.User;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByAdmin(User admin);

//    List<Product> findByNameContainingIgnoreCase(String name);
//
//    List<Product> findByCategory(String category);

    List<Product> findByAdmin_UserId(Long userId);

    @Query("SELECT COALESCE(SUM(oi.quantity), 0) FROM OrderItem oi WHERE oi.product.productId = :productId")
    long getSoldQuantityForProduct(@Param("productId") Long productId);

    @Query("SELECT COALESCE(SUM(oi.quantity), 0) FROM OrderItem oi JOIN oi.order o WHERE o.orderStatus = 'DELIVERED'")
    long getTotalSoldQuantity();
}
