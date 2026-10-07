package com.project.api.wealth_guard.repository;

import com.project.api.wealth_guard.entity.Owner;
import com.project.api.wealth_guard.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    @Query("SELECT p FROM Portfolio p JOIN FETCH p.owner WHERE p.owner IN :owners")
    List<Portfolio> findAllByOwnerId(List<Owner> owners);
}
