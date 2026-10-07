package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.MutualFund;

import java.util.List;

public interface MutualFundService {
    List<MutualFund> findAllByText(String text);
}
