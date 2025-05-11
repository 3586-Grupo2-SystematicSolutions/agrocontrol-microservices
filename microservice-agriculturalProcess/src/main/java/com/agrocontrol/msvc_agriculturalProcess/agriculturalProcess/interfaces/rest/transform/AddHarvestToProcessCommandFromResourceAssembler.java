package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.transform;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands.AddHarvestToProcessCommand;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources.AddHarvestToProcessResource;

public class AddHarvestToProcessCommandFromResourceAssembler {
    public static AddHarvestToProcessCommand toCommandFromResource(AddHarvestToProcessResource resource) {
        return new AddHarvestToProcessCommand(
                resource.date(),
                resource.quantityInKg(),
                resource.pricePerKg(),
                resource.agriculturalProcessId()
        );
    }
}
