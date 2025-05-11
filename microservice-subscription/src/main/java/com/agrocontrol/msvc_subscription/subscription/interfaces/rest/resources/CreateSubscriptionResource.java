package com.agrocontrol.msvc_subscription.subscription.interfaces.rest.resources;

import com.agrocontrol.msvc_subscription.subscription.domain.model.valueobjects.PlanTypes;

public record CreateSubscriptionResource(
        PlanTypes planType,
        Long userId,
        String status,
        double cost
) {
}
