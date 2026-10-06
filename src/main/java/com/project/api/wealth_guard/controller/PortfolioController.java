package com.project.api.wealth_guard.controller;

import com.project.api.wealth_guard.entity.Portfolio;
import com.project.api.wealth_guard.entity.PortfolioHolding;
import com.project.api.wealth_guard.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;

    @QueryMapping
    public Portfolio getPortfolioById(@Argument Long id){
        return portfolioService.getPortfolioById(id);
    }

    @SchemaMapping(typeName = "Portfolio", field = "totalValue")
    public BigDecimal totalValue(Portfolio portfolio){
        return portfolio.getPortfolioHoldings().stream().map(portfolioHolding ->
                portfolioHolding.getAverageBuyPrice().multiply(portfolioHolding.getQuantity())).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
