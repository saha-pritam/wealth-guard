package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.Asset;
import com.project.api.wealth_guard.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService{

    private final AssetRepository assetRepository;

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }
}
