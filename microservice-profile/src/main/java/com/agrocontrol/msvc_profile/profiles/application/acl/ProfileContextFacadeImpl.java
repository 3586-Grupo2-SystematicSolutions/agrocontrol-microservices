package com.agrocontrol.msvc_profile.profiles.application.acl;

import com.agrocontrol.msvc_profile.profiles.domain.model.commands.CreateAgriculturalProducerCommand;
import com.agrocontrol.msvc_profile.profiles.domain.model.commands.CreateDistributorCommand;
import com.agrocontrol.msvc_profile.profiles.domain.model.queries.GetAgriculturalProducerByUserIdAsyncQuery;
import com.agrocontrol.msvc_profile.profiles.domain.model.queries.GetDistributorByUserIdAsyncQuery;
import com.agrocontrol.msvc_profile.profiles.domain.services.AgriculturalProducerCommandService;
import com.agrocontrol.msvc_profile.profiles.domain.services.AgriculturalProducerQueryService;
import com.agrocontrol.msvc_profile.profiles.domain.services.DistributorCommandService;
import com.agrocontrol.msvc_profile.profiles.domain.services.DistributorQueryService;
import com.agrocontrol.msvc_profile.profiles.interfaces.acl.ProfilesContextFacade;
import com.agrocontrol.msvc_profile.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.stereotype.Service;

@Service
public class ProfileContextFacadeImpl implements ProfilesContextFacade {
    private final AgriculturalProducerCommandService agriculturalProducerCommandService;
    private final AgriculturalProducerQueryService agriculturalProducerQueryService;
    private final DistributorCommandService distributorCommandService;
    private final DistributorQueryService distributorQueryService;

    public ProfileContextFacadeImpl(AgriculturalProducerCommandService agriculturalProducerCommandService, AgriculturalProducerQueryService agriculturalProducerQueryService,
                                    DistributorCommandService distributorCommandService, DistributorQueryService distributorQueryService) {
        this.agriculturalProducerCommandService = agriculturalProducerCommandService;
        this.agriculturalProducerQueryService = agriculturalProducerQueryService;
        this.distributorCommandService = distributorCommandService;
        this.distributorQueryService = distributorQueryService;
    }

    @Override
    public Long createAgriculturalProducer(String fullName, String city, String country,
                                           String phone, String dni, Long userId) {

        CreateAgriculturalProducerCommand command = new CreateAgriculturalProducerCommand(
                fullName, city, country, phone, dni);

        var agriculturalProducer = agriculturalProducerCommandService.handle(command, userId);
        return agriculturalProducer.map(AuditableAbstractAggregateRoot::getId).orElse(0L);
    }

    @Override
    public Long createDistributor(String fullName, String city, String country,
                                  String phone, String companyName, String ruc, Long userId) {
        CreateDistributorCommand command = new CreateDistributorCommand(
                fullName, city, country, phone, companyName, ruc);

        var distributor = distributorCommandService.handle(command, userId);
        return distributor.map(AuditableAbstractAggregateRoot::getId).orElse(0L);
    }

    @Override
    public boolean exitsAgriculturalProducerByUserId(Long userId) {
        var query = new GetAgriculturalProducerByUserIdAsyncQuery(userId);
        var existingProducer = agriculturalProducerQueryService.handle(query);
        return existingProducer.isPresent();
    }

    @Override
    public boolean exitsDistributorByUserId(Long userId) {
        var query = new GetDistributorByUserIdAsyncQuery(userId);
        var existingDistributor = distributorQueryService.handle(query);
        return existingDistributor.isPresent();
    }
}