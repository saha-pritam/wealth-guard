package com.project.api.wealth_guard.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExchangeTradedFund implements Asset{
    private long id;
    private String name;
    private String ticker;
    private double currentNav;
    private String exchange;
    private double trackingError;
}
