package com.project.api.wealth_guard.controller;

import com.project.api.wealth_guard.entity.Asset;
import com.project.api.wealth_guard.entity.Portfolio;
import com.project.api.wealth_guard.enums.AssetType;
import com.project.api.wealth_guard.repository.PortfolioHoldingRepository;
import com.project.api.wealth_guard.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AssetController {
    private final AssetService assetService;
    private final PortfolioHoldingRepository portfolioHoldingRepository;

    @QueryMapping
    public List<Asset> getMarketAssets(){
        return assetService.getAllAssets();
    }

    @QueryMapping
    public List<Asset> getAssetByType(@Argument AssetType assetType){
        return assetService.getAssetsByType(assetType);
    }

    @MutationMapping
    public Portfolio buyAsset(@Argument Long portfolioId, @Argument Long assetId, @Argument BigDecimal quantity){
        return assetService.buyAsset(portfolioId, assetId, quantity);
    }

    @MutationMapping
    public Portfolio sellAsset(@Argument Long portfolioId, @Argument Long assetId, @Argument BigDecimal quantity){
        return assetService.sellAsset(portfolioId, assetId, quantity);
    }

    @MutationMapping
    public Asset updateNavPrice(@Argument String ticker, @Argument BigDecimal newNav){
        return assetService.updateNavPrice(ticker, newNav);
    }
}
