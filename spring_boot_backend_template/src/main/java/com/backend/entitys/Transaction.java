package com.backend.entitys;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode = PaymentMode.COD;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.SUCCESS;

    private LocalDateTime transactionDate = LocalDateTime.now();
}


//@Entity
//@Table(name = "transactions")
//@Getter @Setter
//@NoArgsConstructor @AllArgsConstructor
//public class Transaction {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long transactionId;
//
//    @OneToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    private String status;
//    private Double amount;
//
//    private LocalDateTime transactionDate = LocalDateTime.now();
//}
