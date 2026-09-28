package com.project.api.wealth_guard.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MutualFund implements Asset{
    private long id;
    private String name;
    private String ticker;
    private double currentNav;
    private String fundCategory;
    private double expenseRatio;
    private double exitLoad;
}
