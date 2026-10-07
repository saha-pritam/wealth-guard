package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.ExchangeTradedFund;
import com.project.api.wealth_guard.repository.ExchangeTradedFundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeTradedFundServiceImpl implements ExchangeTradedFundService{
    private final ExchangeTradedFundRepository exchangeTradedFundRepository;

    @Override
    public List<ExchangeTradedFund> findAllByText(String text) {
        return exchangeTradedFundRepository.findAllByText(text);
    }
}
