package com.agrocontrol.msvc_subscription.subscription.interfaces.rest.transform;

import com.agrocontrol.msvc_subscription.subscription.domain.model.commands.RenewSubscriptionCommand;
import com.agrocontrol.msvc_subscription.subscription.interfaces.rest.resources.RenewSubscriptionResource;

public class RenewSubscriptionCommandFromResourceAssembler {
    public static RenewSubscriptionCommand toCommandFromResource(RenewSubscriptionResource resource, Long id) {
        return new RenewSubscriptionCommand(
            resource.renewalDate(),
            id
        );
    }
}
