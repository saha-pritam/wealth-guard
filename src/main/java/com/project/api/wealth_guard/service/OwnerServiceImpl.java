package com.project.api.wealth_guard.service;

import com.project.api.wealth_guard.entity.Owner;
import com.project.api.wealth_guard.entity.Portfolio;
import com.project.api.wealth_guard.repository.OwnerRepository;
import com.project.api.wealth_guard.repository.PortfolioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService{
    private final OwnerRepository ownerRepository;
    private final PortfolioRepository portfolioRepository;

    @Override
    public List<Owner> findByText(String text) {
        return ownerRepository.findAllByText(text);
    }

    @Override
    public Map<Owner, Portfolio> portfolio(List<Owner> owners) {
        Map<Long, Owner> ownerMap = owners.stream().collect(Collectors.toMap(Owner::getId, owner -> owner));
        List<Portfolio> portfolios = portfolioRepository.findAllByOwnerId(owners);
        Map<Owner, Portfolio> ownerPortfolioMap = portfolios.stream().collect(Collectors.toMap(portfolio -> ownerMap.get(portfolio.getOwner().getId()), portfolio -> portfolio));
        return ownerPortfolioMap;
    }

    @Transactional
    @Override
    public Owner register(Owner owner) {
        owner = ownerRepository.save(owner);
        portfolioRepository.save(new Portfolio(owner));
        return owner;
    }
}
