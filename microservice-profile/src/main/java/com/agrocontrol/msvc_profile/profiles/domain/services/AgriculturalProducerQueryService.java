package com.agrocontrol.msvc_profile.profiles.domain.services;

import com.agrocontrol.msvc_profile.profiles.domain.model.aggregates.AgriculturalProducer;
import com.agrocontrol.msvc_profile.profiles.domain.model.queries.GetAgriculturalProducerByUserIdAsyncQuery;

import java.util.Optional;

public interface AgriculturalProducerQueryService {
    Optional<AgriculturalProducer> handle(GetAgriculturalProducerByUserIdAsyncQuery query);
}
