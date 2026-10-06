package com.project.api.wealth_guard.controller;

import com.project.api.wealth_guard.entity.Asset;
import com.project.api.wealth_guard.entity.PortfolioHolding;
import com.project.api.wealth_guard.service.AssetService;
import com.project.api.wealth_guard.service.PortfolioHoldingService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PortfolioHoldingController {
    private final AssetService assetService;
    private final PortfolioHoldingService portfolioHoldingService;

    @BatchMapping(typeName = "PortfolioHolding", field = "asset")
    public Map<PortfolioHolding, Asset> asset(List<PortfolioHolding> portfolioHoldings){
        return assetService.getAssetByPortfolioHoldings(portfolioHoldings);
    }

    @QueryMapping
    List<PortfolioHolding> getTopHoldings(@Argument Long portfolioId, @Argument Integer limit){
        return portfolioHoldingService.getTopHoldingsByPortfolioId(portfolioId, limit);
    }
}
