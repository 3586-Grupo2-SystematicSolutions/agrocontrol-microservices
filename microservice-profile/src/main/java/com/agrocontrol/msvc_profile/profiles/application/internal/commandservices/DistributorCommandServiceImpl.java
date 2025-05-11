package com.agrocontrol.msvc_profile.profiles.application.internal.commandservices;

import com.agrocontrol.msvc_profile.profiles.domain.model.aggregates.Distributor;
import com.agrocontrol.msvc_profile.profiles.domain.model.commands.CreateDistributorCommand;
import com.agrocontrol.msvc_profile.profiles.domain.services.DistributorCommandService;
import com.agrocontrol.msvc_profile.profiles.infrastructure.persistence.jpa.repositories.DistributorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistributorCommandServiceImpl implements DistributorCommandService {
    private final DistributorRepository distributorRepository;

    public DistributorCommandServiceImpl(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
    }

    @Override
    public Optional<Distributor> handle(CreateDistributorCommand command, Long userId) {
        if (distributorRepository.existsByPhone_Phone(command.phone())){
            throw new IllegalArgumentException("Phone already exists");
        }

        if (distributorRepository.existsByRuc_Ruc(command.ruc())){
            throw new IllegalArgumentException("Ruc already exists");
        }

        var distributor = new Distributor(command, userId);
        var createdDistributor = distributorRepository.save(distributor);
        return Optional.of(createdDistributor);
    }
}
