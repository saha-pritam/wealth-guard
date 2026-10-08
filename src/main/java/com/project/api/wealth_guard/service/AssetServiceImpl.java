package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.Asset;
import com.project.api.wealth_guard.entity.Portfolio;
import com.project.api.wealth_guard.entity.PortfolioHolding;
import com.project.api.wealth_guard.enums.AssetType;
import com.project.api.wealth_guard.repository.AssetRepository;
import com.project.api.wealth_guard.repository.PortfolioHoldingRepository;
import com.project.api.wealth_guard.repository.PortfolioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService{

    private final AssetRepository assetRepository;
    private final PortfolioRepository portfolioRepository;
    private final PortfolioHoldingRepository portfolioHoldingRepository;

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Map<PortfolioHolding, Asset> getAssetByPortfolioHoldings(List<PortfolioHolding> portfolioHoldings) {
        Set<Long> assetIds = portfolioHoldings.stream()
                .map(portfolioHolding -> portfolioHolding.getAsset() != null ? portfolioHolding.getAsset().getId() : null)
                .collect(Collectors.toSet());
        List<Asset> assets = assetRepository.findAllById(assetIds);
        Map<Long, Asset> assetMap = assets.stream().collect(Collectors.toMap(Asset::getId, asset -> (Asset)Hibernate.unproxy(asset)));
        return portfolioHoldings.stream()
                .collect(Collectors.toMap(portfolioHolding -> portfolioHolding, portfolioHolding -> assetMap.get(portfolioHolding.getAsset()!=null?portfolioHolding.getAsset().getId():null)));
    }

    @Override
    public List<Asset> getAssetsByType(AssetType assetType) {
        return switch (assetType){
            case AssetType.ExchangeTradedFund -> assetRepository.findAllExchangeTradedFunds();
            case AssetType.MutualFund -> assetRepository.findAllMutualFunds();
            case AssetType.Debenture -> assetRepository.findAllDebentures();
        };
    }

    @Override
    @Transactional
    public Portfolio buyAsset(Long portfolioId, Long assetId, BigDecimal quantity) {
        Asset asset = assetRepository.findById(assetId).orElseThrow(() -> new RuntimeException("Asset not found with id: " + assetId + ""));
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(() -> new RuntimeException("Portfolio not found with id: " + portfolioId + ""));
        PortfolioHolding portfolioHolding = portfolioHoldingRepository.findByPortfolioAndAsset(portfolio, asset);
        if(portfolioHolding == null){
            portfolioHolding = new PortfolioHolding();
            portfolioHolding.setPortfolio(portfolio);
            portfolioHolding.setAsset(asset);
            portfolioHolding.setQuantity(quantity);
            portfolioHolding.setAverageBuyPrice(asset.getCurrentNav());
        }
        else {
            BigDecimal totalQuantity = portfolioHolding.getQuantity().add(quantity);
            BigDecimal newAverageBuyPrice = portfolioHolding.getQuantity().multiply(portfolioHolding.getAverageBuyPrice()).add(quantity.multiply(asset.getCurrentNav())).divide(totalQuantity, 2, BigDecimal.ROUND_HALF_UP);
            portfolioHolding.setAverageBuyPrice(newAverageBuyPrice);
            portfolioHolding.setQuantity(totalQuantity);
        }
        portfolioHoldingRepository.save(portfolioHolding);
        return portfolio;
    }
}
