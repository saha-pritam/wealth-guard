package com.project.api.wealth_guard.entity;

public interface Asset {
    long getId();
    void setId(long id);
    String getName();
    void setName(String name);
    String getTicker();
    void setTicker(String ticker);
    double getCurrentNav();
    void setCurrentNav(double currentNav);
}
