package com.project.api.wealth_guard.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "asset")
public abstract class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String ticker;
    @Column(precision = 19, scale = 4)
    private BigDecimal currentNav;
    @OneToMany(mappedBy = "asset")
    @ToString.Exclude
    private List<PortfolioHolding> portfolioHoldings;
}
