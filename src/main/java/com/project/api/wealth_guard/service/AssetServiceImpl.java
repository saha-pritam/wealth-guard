package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.Asset;
import com.project.api.wealth_guard.entity.PortfolioHolding;
import com.project.api.wealth_guard.enums.AssetType;
import com.project.api.wealth_guard.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService{

    private final AssetRepository assetRepository;

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
}
