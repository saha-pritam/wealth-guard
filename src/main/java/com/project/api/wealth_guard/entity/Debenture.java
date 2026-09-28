package com.project.api.wealth_guard.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Debenture implements Asset{
    private long id;
    private String name;
    private String ticker;
    private double currentNav;
    private double couponRate;
    private LocalDate maturityDate;
}
