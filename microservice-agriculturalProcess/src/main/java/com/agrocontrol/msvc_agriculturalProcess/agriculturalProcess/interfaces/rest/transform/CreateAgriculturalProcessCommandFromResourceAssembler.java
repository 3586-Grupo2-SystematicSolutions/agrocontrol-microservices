package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.transform;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands.CreateAgriculturalProcessCommand;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources.CreateAgriculturalProcessResource;

public class CreateAgriculturalProcessCommandFromResourceAssembler {
    public static CreateAgriculturalProcessCommand toCommandFromResource(CreateAgriculturalProcessResource resource) {
        return new CreateAgriculturalProcessCommand(resource.fieldId());
    }
}
