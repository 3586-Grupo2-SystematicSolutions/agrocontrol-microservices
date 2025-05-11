package com.agrocontrol.msvc_payment.payment.domain.model.commands;

import java.time.LocalDate;

public record CreatePaymentCommand(
        Long subscriptionId,
        LocalDate date,
        String state,
        String cardHolderName,
        String cardNumber,
        String ExpireDate,
        String cvv
) {
}
