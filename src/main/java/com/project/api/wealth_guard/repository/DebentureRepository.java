package com.project.api.wealth_guard.repository;

import com.project.api.wealth_guard.entity.Debenture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebentureRepository extends JpaRepository<Debenture, Long> {

    @Query("SELECT d FROM Debenture d WHERE d.name=:text OR d.ticker=:text")
    List<Debenture> findAllByText(String text);
}
