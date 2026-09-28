package com.project.api.wealth_guard.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PortfolioHolding {
    private Asset asset;
    private double quantity;
    private double averageBuyPrice;
}
