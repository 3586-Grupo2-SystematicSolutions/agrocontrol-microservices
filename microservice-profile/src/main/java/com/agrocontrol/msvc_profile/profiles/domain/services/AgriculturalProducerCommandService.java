package com.agrocontrol.msvc_profile.profiles.domain.services;

import com.agrocontrol.msvc_profile.profiles.domain.model.aggregates.AgriculturalProducer;
import com.agrocontrol.msvc_profile.profiles.domain.model.commands.CreateAgriculturalProducerCommand;

import java.util.Optional;

public interface AgriculturalProducerCommandService {
    Optional<AgriculturalProducer> handle(CreateAgriculturalProducerCommand command, Long userId);
}
