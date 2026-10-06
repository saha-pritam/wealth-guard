package com.project.api.wealth_guard.controller;

import com.project.api.wealth_guard.entity.Asset;
import com.project.api.wealth_guard.enums.AssetType;
import com.project.api.wealth_guard.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AssetController {
    private final AssetService assetService;

    @QueryMapping
    public List<Asset> getMarketAssets(){
        return assetService.getAllAssets();
    }

    @QueryMapping
    public List<Asset> getAssetByType(@Argument AssetType assetType){
        return assetService.getAssetsByType(assetType);
    }
}
