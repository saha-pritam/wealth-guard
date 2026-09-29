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
@Table(name = "mutual_fund")
public class MutualFund extends Asset{
    private String fundCategory;
    @Column(precision = 19, scale = 4)
    private BigDecimal expenseRatio;
    @Column(precision = 19, scale = 4)
    private BigDecimal exitLoad;
}
