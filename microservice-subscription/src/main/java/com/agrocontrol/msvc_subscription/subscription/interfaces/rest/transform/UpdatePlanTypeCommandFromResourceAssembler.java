package com.agrocontrol.msvc_subscription.subscription.interfaces.rest.transform;

import com.agrocontrol.msvc_subscription.subscription.domain.model.commands.UpdatePlanTypeCommand;
import com.agrocontrol.msvc_subscription.subscription.interfaces.rest.resources.UpdatePlantTypeResource;

public class UpdatePlanTypeCommandFromResourceAssembler {
    public static UpdatePlanTypeCommand toCommandFromResource(UpdatePlantTypeResource resource, Long id) {
        return new UpdatePlanTypeCommand(
            resource.planType(),
            id
        );
    }
}
