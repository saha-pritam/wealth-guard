package com.project.api.wealth_guard.repository;

import com.project.api.wealth_guard.entity.ExchangeTradedFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeTradedFundRepository extends JpaRepository<ExchangeTradedFund, Long> {

    @Query("SELECT etf FROM ExchangeTradedFund etf WHERE etf.name=:text OR etf.ticker=:text OR etf.exchange=:text")
    List<ExchangeTradedFund> findAllByText(String text);
}
