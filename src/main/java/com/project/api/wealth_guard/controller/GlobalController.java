package com.project.api.wealth_guard.controller;

import com.project.api.wealth_guard.entity.SearchResult;
import com.project.api.wealth_guard.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GlobalController {
    private final DebentureService debentureService;
    private final ExchangeTradedFundService exchangeTradedFundService;
    private final MutualFundService mutualFundService;
    private final OwnerService ownerService;

    @QueryMapping
    List<SearchResult> globalSearch(@Argument String text){
        List<SearchResult> searchResults = new ArrayList<>();
        searchResults.addAll(debentureService.findAllByText(text));
        searchResults.addAll(exchangeTradedFundService.findAllByText(text));
        searchResults.addAll(mutualFundService.findAllByText(text));
        searchResults.addAll(ownerService.findByText(text));
        return searchResults;
    }

}
