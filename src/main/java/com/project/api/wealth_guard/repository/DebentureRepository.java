package com.project.api.wealth_guard.repository;

import com.project.api.wealth_guard.entity.Debenture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebentureRepository extends JpaRepository<Debenture, Long> {
}
