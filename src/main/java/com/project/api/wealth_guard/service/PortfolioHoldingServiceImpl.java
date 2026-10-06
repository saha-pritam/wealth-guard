package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.PortfolioHolding;
import com.project.api.wealth_guard.repository.PortfolioHoldingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioHoldingServiceImpl implements PortfolioHoldingService{

    private final PortfolioHoldingRepository portfolioHoldingRepository;

    @Override
    public List<PortfolioHolding> getTopHoldingsByPortfolioId(Long portfolioId, int limit) {
        Pageable pageable = PageRequest.of(0, limit).withSort(Sort.by("averageBuyPrice").descending());
        return portfolioHoldingRepository.findByPortfolioId(portfolioId, pageable).getContent();
    }
}
