package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.transform;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands.AddIrrigationToProcessCommand;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources.AddIrrigationToProcessResource;

public class AddIrrigationToProcessCommandFromResourceAssembler {
    public static AddIrrigationToProcessCommand toCommandFromResource(AddIrrigationToProcessResource resource) {
        return new AddIrrigationToProcessCommand(
                resource.date(),
                resource.hoursIrrigated(),
                resource.agriculturalProcessId()
        );
    }
}
