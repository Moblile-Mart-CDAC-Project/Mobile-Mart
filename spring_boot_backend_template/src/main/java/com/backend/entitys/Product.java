package com.backend.entitys;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Table(name = "products")
//@Getter @Setter
//@NoArgsConstructor @AllArgsConstructor
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long productId;
//
//    private String name;
//    private String brand;
//
//    @Column(columnDefinition = "TEXT")
//    private String description;
//
//    private Double price;
//    private Integer stockQuantity;
//
//    private Boolean isActive = true;
//
//    @ManyToOne
//    @JoinColumn(name = "created_by", nullable = false)
//    private User admin;
//
//    private LocalDateTime createdAt = LocalDateTime.now();
//}


@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String name;

    private String brand;

    @Column(nullable = false)
    private Double price;

    private Integer stockQuantity;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User admin;

    private LocalDateTime createdAt = LocalDateTime.now();
}

