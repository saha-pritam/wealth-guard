package com.project.api.wealth_guard.repository;

import com.project.api.wealth_guard.entity.Asset;
import com.project.api.wealth_guard.entity.Portfolio;
import com.project.api.wealth_guard.entity.PortfolioHolding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioHoldingRepository extends JpaRepository<PortfolioHolding, Long> {
    Page<PortfolioHolding> findByPortfolioId(Long portfolioId, Pageable pageable);

    PortfolioHolding findByPortfolioAndAsset(Portfolio portfolio, Asset asset);
}
