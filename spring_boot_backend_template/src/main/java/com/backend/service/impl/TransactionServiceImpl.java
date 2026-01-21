//package com.backend.service.impl;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//import com.backend.dto.TransactionDto;
//import com.backend.entitys.Order;
//import com.backend.entitys.Transaction;
//import com.backend.repository.OrderRepository;
//import com.backend.repository.TransactionRepository;
//import com.backend.service.TransactionService;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class TransactionServiceImpl implements TransactionService {
//
//    private final TransactionRepository transactionRepository;
//    private final OrderRepository orderRepository;
//    private final ModelMapper modelMapper;
//
//    @Override
//    public TransactionDto pay(Long orderId) {
//        Order order = orderRepository.findById(orderId).orElseThrow();
//
//        Transaction tx = new Transaction(order, "SUCCESS");
//        return modelMapper.map(
//                transactionRepository.save(tx),
//                TransactionDto.class
//        );
//    }
//
//    @Override
//    public TransactionDto status(Long orderId) {
//        return modelMapper.map(
//                transactionRepository.findByOrderId(orderId).orElseThrow(),
//                TransactionDto.class
//        );
//    }
//}
//
