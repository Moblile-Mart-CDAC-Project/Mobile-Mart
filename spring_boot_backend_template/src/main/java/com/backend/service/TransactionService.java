package com.backend.service;

import com.backend.dto.TransactionDto;

public interface TransactionService {
		TransactionDto pay(Long orderId);
	    TransactionDto status(Long orderId);
}
