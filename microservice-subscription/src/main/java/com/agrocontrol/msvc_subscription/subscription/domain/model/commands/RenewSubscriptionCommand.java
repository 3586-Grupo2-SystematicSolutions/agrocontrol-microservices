package com.agrocontrol.msvc_subscription.subscription.domain.model.commands;

import java.time.LocalDate;

public record RenewSubscriptionCommand(
        LocalDate renewalDate,
        Long paymentId
) {
}
