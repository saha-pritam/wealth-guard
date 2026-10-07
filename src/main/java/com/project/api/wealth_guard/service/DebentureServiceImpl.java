package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.Debenture;
import com.project.api.wealth_guard.repository.DebentureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DebentureServiceImpl implements DebentureService{
    private final DebentureRepository debentureRepository;

    @Override
    public List<Debenture> findAllByText(String text) {
        return debentureRepository.findAllByText(text);
    }
}
