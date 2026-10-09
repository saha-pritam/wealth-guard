package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.Asset;
import com.project.api.wealth_guard.entity.Portfolio;
import com.project.api.wealth_guard.entity.PortfolioHolding;
import com.project.api.wealth_guard.enums.AssetType;
import org.springframework.graphql.data.method.annotation.Argument;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface AssetService {
    List<Asset> getAllAssets();
    Map<PortfolioHolding, Asset> getAssetByPortfolioHoldings(List<PortfolioHolding> portfolioHoldings);
    List<Asset> getAssetsByType(AssetType assetType);
    Portfolio buyAsset(Long portfolioId, Long assetId, BigDecimal quantity);
    Portfolio sellAsset(Long portfolioId, Long assetId, BigDecimal quantity);
    Asset updateNavPrice(String ticker, BigDecimal navPrice);
}
