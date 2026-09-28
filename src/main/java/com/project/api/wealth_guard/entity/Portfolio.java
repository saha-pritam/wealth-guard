package com.project.api.wealth_guard.entity;

import lombok.*;
import lombok.ToString.Exclude;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Portfolio {
    private long id;
    @Exclude
    private Owner owner;
    private List<PortfolioHolding> portfolioHoldings;
    private double totalValue;
}
