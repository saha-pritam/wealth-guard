package com.project.api.wealth_guard.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "portfolio_holding")
public class PortfolioHolding {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    @Column(precision = 19, scale = 4)
    private BigDecimal quantity;
    @Column(precision = 19, scale = 4)
    private BigDecimal averageBuyPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="asset_id",nullable = false)
    @ToString.Exclude
    private Asset asset;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="portfolio_id", nullable = false)
    @ToString.Exclude
    private Portfolio portfolio;
}
