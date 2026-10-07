package com.project.api.wealth_guard.entity;

public sealed interface SearchResult permits Debenture, MutualFund, ExchangeTradedFund, Owner{
}
