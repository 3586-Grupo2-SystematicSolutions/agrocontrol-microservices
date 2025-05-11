package com.agrocontrol.msvc_profile.profiles.domain.services;

import com.agrocontrol.msvc_profile.profiles.domain.model.aggregates.Distributor;
import com.agrocontrol.msvc_profile.profiles.domain.model.queries.GetDistributorByUserIdAsyncQuery;

import java.util.Optional;

public interface DistributorQueryService {
    Optional<Distributor> handle(GetDistributorByUserIdAsyncQuery query);
}
