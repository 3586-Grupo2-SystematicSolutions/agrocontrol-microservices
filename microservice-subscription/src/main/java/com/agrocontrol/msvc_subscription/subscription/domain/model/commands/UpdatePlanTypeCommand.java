package com.agrocontrol.msvc_subscription.subscription.domain.model.commands;

import com.agrocontrol.msvc_subscription.subscription.domain.model.valueobjects.PlanTypes;

public record UpdatePlanTypeCommand(
        PlanTypes planType,
        Long paymentId
) {
}
