package com.agrocontrol.msvc_subscription.subscription.interfaces.rest.transform;

import com.agrocontrol.msvc_subscription.subscription.domain.model.aggregates.Subscription;
import com.agrocontrol.msvc_subscription.subscription.interfaces.rest.resources.SubscriptionResource;

public class SubscriptionResourceFromEntityAssembler {
    public static SubscriptionResource toResourceFromEntity(Subscription entity) {
        return new SubscriptionResource(
                entity.getId(),
                entity.getPlanType().name(),
                entity.getUserId(),
                entity.getStartDate(),
                entity.getRenewalDate(),
                entity.getStatus(),
                entity.getCost()
        );
    }
}
