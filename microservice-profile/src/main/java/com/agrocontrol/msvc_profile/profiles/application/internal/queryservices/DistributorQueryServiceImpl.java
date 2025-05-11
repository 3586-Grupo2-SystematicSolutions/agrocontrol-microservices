package com.agrocontrol.msvc_profile.profiles.application.internal.queryservices;

import com.agrocontrol.msvc_profile.profiles.domain.model.aggregates.Distributor;
import com.agrocontrol.msvc_profile.profiles.domain.model.queries.GetDistributorByUserIdAsyncQuery;
import com.agrocontrol.msvc_profile.profiles.domain.services.DistributorQueryService;
import com.agrocontrol.msvc_profile.profiles.infrastructure.persistence.jpa.repositories.DistributorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistributorQueryServiceImpl implements DistributorQueryService {
    private final DistributorRepository distributorRepository;

    public DistributorQueryServiceImpl(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
    }

    @Override
    public Optional<Distributor> handle(GetDistributorByUserIdAsyncQuery query) {
        return distributorRepository.findDistributorByUserId(query.userId());
    }
}
