package com.project.api.wealth_guard.repository;

import com.project.api.wealth_guard.entity.PortfolioHolding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioHoldingRepository extends JpaRepository<PortfolioHolding, Long> {
}
