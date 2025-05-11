package com.agrocontrol.msvc_profile.profiles.application.internal.queryservices;

import com.agrocontrol.msvc_profile.profiles.domain.model.aggregates.AgriculturalProducer;
import com.agrocontrol.msvc_profile.profiles.domain.model.queries.GetAgriculturalProducerByUserIdAsyncQuery;
import com.agrocontrol.msvc_profile.profiles.domain.services.AgriculturalProducerQueryService;
import com.agrocontrol.msvc_profile.profiles.infrastructure.persistence.jpa.repositories.AgriculturalProducerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgriculturalProducerQueryServiceImpl implements AgriculturalProducerQueryService {
    private final AgriculturalProducerRepository agriculturalProducerRepository;

    public AgriculturalProducerQueryServiceImpl(AgriculturalProducerRepository agriculturalProducerRepository) {
        this.agriculturalProducerRepository = agriculturalProducerRepository;
    }

    @Override
    public Optional<AgriculturalProducer> handle(GetAgriculturalProducerByUserIdAsyncQuery query) {
        return agriculturalProducerRepository.findAgriculturalProducerByUserId(query.userId());
    }
}
