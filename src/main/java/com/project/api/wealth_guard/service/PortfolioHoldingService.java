package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.PortfolioHolding;

import java.util.List;

public interface PortfolioHoldingService {
    List<PortfolioHolding> getTopHoldingsByPortfolioId(Long portfolioId, int limit);
}
