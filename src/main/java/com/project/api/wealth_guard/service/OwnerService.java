package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.Owner;
import com.project.api.wealth_guard.entity.Portfolio;

import java.util.List;
import java.util.Map;

public interface OwnerService {
    List<Owner> findByText(String text);
    Map<Owner, Portfolio> portfolio(List<Owner> owners);
}
