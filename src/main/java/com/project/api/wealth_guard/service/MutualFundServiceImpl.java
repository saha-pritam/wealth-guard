package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.MutualFund;
import com.project.api.wealth_guard.repository.MutualFundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MutualFundServiceImpl implements MutualFundService{
    private final MutualFundRepository mutualFundRepository;

    @Override
    public List<MutualFund> findAllByText(String text) {
        return mutualFundRepository.findAllByText(text);
    }
}
