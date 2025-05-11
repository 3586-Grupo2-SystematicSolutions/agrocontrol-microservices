package com.agrocontrol.msvc_subscription.subscription.interfaces.rest.resources;

import java.time.LocalDate;

public record SubscriptionResource(
        Long id,
        String planType,
        Long userId,
        LocalDate startDate,
        LocalDate renewalDate,
        String status,
        double cost
) {
}
