package com.project.api.wealth_guard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "exchange_traded_fund")
public non-sealed class ExchangeTradedFund extends Asset implements SearchResult{
    private String exchange;
    @Column(precision = 19, scale = 4)
    private BigDecimal trackingError;
}
