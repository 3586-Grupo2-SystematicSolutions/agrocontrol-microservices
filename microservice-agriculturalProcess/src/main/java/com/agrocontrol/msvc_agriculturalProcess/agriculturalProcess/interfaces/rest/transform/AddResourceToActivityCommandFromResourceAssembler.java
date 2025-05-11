package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.transform;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands.AddResourceToActivityCommand;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources.AddResourceToActivityResource;

public class AddResourceToActivityCommandFromResourceAssembler {
    public static AddResourceToActivityCommand toCommandFromResource(AddResourceToActivityResource resource) {
        return new AddResourceToActivityCommand(
                resource.resourceId(),
                resource.description(),
                resource.cost(),
                resource.quantity(),
                resource.activityId(),
                resource.agriculturalProcessId()
        );
    }
}
