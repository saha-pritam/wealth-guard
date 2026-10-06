package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.Asset;
import com.project.api.wealth_guard.entity.PortfolioHolding;

import java.util.List;
import java.util.Map;

public interface AssetService {
    List<Asset> getAllAssets();
    Map<PortfolioHolding, Asset> getAssetByPortfolioHoldings(List<PortfolioHolding> portfolioHoldings);
}
