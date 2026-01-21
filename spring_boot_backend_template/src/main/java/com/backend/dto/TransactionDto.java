package com.backend.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
//    private Long id;
//    private String status;
//    private double amount;
	
	    private Long transactionId;
	    private String paymentMode;
	    private String paymentStatus;
}

