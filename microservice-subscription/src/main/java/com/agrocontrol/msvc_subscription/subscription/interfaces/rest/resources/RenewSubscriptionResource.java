package com.agrocontrol.msvc_subscription.subscription.interfaces.rest.resources;

import java.time.LocalDate;

public record RenewSubscriptionResource(
        LocalDate renewalDate
) {
}
