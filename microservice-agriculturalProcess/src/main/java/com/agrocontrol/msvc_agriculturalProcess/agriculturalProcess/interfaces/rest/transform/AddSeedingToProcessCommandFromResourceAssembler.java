package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.transform;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands.AddSeedingToProcessCommand;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources.AddSeedingToProcessResource;

public class AddSeedingToProcessCommandFromResourceAssembler {
    public static AddSeedingToProcessCommand toCommandFromResource(AddSeedingToProcessResource resource) {
        return new AddSeedingToProcessCommand(
                resource.date(),
                resource.plantType(),
                resource.quantityPlanted(),
                resource.agriculturalProcessId()
        );
    }
}
