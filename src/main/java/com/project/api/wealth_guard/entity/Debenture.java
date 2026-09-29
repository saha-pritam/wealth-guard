package com.project.api.wealth_guard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "debenture")
public class Debenture extends Asset{
    @Column(precision = 19, scale = 4)
    private BigDecimal couponRate;
    private LocalDate maturityDate;
}
