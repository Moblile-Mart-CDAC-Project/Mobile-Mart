package com.backend.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entitys.Order;
import com.backend.entitys.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	 Optional<Transaction> findByOrder(Order order);}
