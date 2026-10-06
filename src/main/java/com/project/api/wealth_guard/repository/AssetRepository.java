package com.project.api.wealth_guard.repository;

import com.project.api.wealth_guard.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    @Query("SELECT asset FROM Asset asset WHERE TYPE(asset) = ExchangeTradedFund")
    List<Asset> findAllExchangeTradedFunds();

    @Query("SELECT asset FROM Asset asset WHERE TYPE(asset) = MutualFund")
    List<Asset> findAllMutualFunds();

    @Query("SELECT asset FROM Asset asset WHERE TYPE(asset) = Debenture")
    List<Asset> findAllDebentures();
}
