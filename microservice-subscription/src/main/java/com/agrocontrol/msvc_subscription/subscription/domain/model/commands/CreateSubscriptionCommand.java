package com.agrocontrol.msvc_subscription.subscription.domain.model.commands;

import com.agrocontrol.msvc_subscription.subscription.domain.model.valueobjects.PlanTypes;

public record CreateSubscriptionCommand(
        PlanTypes planType,
        Long userId,
        String status,
        double cost
) {
}
