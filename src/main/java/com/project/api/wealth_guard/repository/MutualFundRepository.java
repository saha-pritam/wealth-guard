package com.project.api.wealth_guard.repository;

import com.project.api.wealth_guard.entity.MutualFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MutualFundRepository extends JpaRepository<MutualFund, Long> {

    @Query("SELECT mf FROM MutualFund mf WHERE mf.name=:text OR mf.ticker=:text OR mf.fundCategory=:text")
    List<MutualFund> findAllByText(String text);
}
