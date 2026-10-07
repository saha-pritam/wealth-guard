package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.ExchangeTradedFund;

import java.util.List;

public interface ExchangeTradedFundService {
    List<ExchangeTradedFund> findAllByText(String text);
}
