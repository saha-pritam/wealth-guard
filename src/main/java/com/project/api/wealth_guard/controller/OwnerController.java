package com.project.api.wealth_guard.controller;

import com.project.api.wealth_guard.dto.input.OwnerInput;
import com.project.api.wealth_guard.entity.Owner;
import com.project.api.wealth_guard.entity.Portfolio;
import com.project.api.wealth_guard.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @BatchMapping(typeName = "Owner", field = "portfolio")
    public Map<Owner, Portfolio> portfolio(List<Owner> owners){
        return ownerService.portfolio(owners);
    }

    @MutationMapping
    public Owner registerOwner(@Argument OwnerInput ownerInput){
        return ownerService.register(new Owner(ownerInput));
    }
}
