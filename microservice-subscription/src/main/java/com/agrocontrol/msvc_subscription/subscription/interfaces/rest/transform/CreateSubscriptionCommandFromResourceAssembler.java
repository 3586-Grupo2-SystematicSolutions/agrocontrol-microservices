package com.agrocontrol.msvc_subscription.subscription.interfaces.rest.transform;

import com.agrocontrol.msvc_subscription.subscription.domain.model.commands.CreateSubscriptionCommand;
import com.agrocontrol.msvc_subscription.subscription.interfaces.rest.resources.CreateSubscriptionResource;

public class CreateSubscriptionCommandFromResourceAssembler {
    public static CreateSubscriptionCommand toCommandFromResource(CreateSubscriptionResource resource) {
        return new CreateSubscriptionCommand(
                resource.planType(),
                resource.userId(),
                resource.status(),
                resource.cost()
        );
    }
}
