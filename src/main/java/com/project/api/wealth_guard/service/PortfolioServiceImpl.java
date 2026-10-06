package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.Portfolio;
import com.project.api.wealth_guard.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService{
    private final PortfolioRepository portfolioRepository;

    @Override
    public Portfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id).orElseThrow(() -> new RuntimeException("Portfolio not found with id: " + id + ""));
    }
}
