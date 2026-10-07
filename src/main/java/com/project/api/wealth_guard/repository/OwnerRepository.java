package com.project.api.wealth_guard.repository;

import com.project.api.wealth_guard.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    @Query("SELECT o FROM Owner o WHERE o.firstName=:text OR o.middleName=:text OR o.lastName=:text OR o.mobile=:text")
    List<Owner> findAllByText(String text);
}
