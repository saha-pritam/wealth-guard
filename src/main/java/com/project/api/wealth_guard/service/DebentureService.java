package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.Debenture;

import java.util.List;

public interface DebentureService {
    List<Debenture> findAllByText(String text);
}
