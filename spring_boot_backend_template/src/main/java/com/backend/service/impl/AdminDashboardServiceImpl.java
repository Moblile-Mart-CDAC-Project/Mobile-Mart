package com.backend.service.impl;

import org.springframework.stereotype.Service;
import com.backend.dto.DashboardStatsDto;
import com.backend.repository.ProductRepository;
import com.backend.repository.OrderRepository;
import com.backend.service.AdminDashboardService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminDashboardServiceImpl implements AdminDashboardService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public DashboardStatsDto getStats() {
        long totalProducts = productRepository.count();
        long totalSold = productRepository.getTotalSoldQuantity();
        double revenue = orderRepository.getTotalRevenue();

        return new DashboardStatsDto(totalProducts, totalSold, revenue);
    }
}
