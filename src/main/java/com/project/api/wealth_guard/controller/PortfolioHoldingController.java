package com.project.api.wealth_guard.controller;

import com.project.api.wealth_guard.entity.Asset;
import com.project.api.wealth_guard.entity.PortfolioHolding;
import com.project.api.wealth_guard.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PortfolioHoldingController {
    private final AssetService assetService;

    @BatchMapping(typeName = "PortfolioHolding", field = "asset")
    public Map<PortfolioHolding, Asset> asset(List<PortfolioHolding> portfolioHoldings){
        return assetService.getAssetByPortfolioHoldings(portfolioHoldings);
    }
}
