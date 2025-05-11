package com.agrocontrol.msvc_profile.profiles.domain.services;

import com.agrocontrol.msvc_profile.profiles.domain.model.aggregates.Distributor;
import com.agrocontrol.msvc_profile.profiles.domain.model.commands.CreateDistributorCommand;

import java.util.Optional;

public interface DistributorCommandService {
    Optional<Distributor> handle(CreateDistributorCommand command, Long userId);
}
