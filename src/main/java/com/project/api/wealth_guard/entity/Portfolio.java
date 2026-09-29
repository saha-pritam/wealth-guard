package com.project.api.wealth_guard.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.ToString.Exclude;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Transient
    private BigDecimal totalValue;
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name="owner_id")
    private Owner owner;
    @ToString.Exclude
    @OneToMany(mappedBy = "portfolio")
    private List<PortfolioHolding> portfolioHoldings;
}
