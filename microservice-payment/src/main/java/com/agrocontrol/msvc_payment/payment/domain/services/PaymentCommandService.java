package com.agrocontrol.msvc_payment.payment.domain.services;

import com.agrocontrol.msvc_payment.payment.domain.model.aggregates.Payment;
import com.agrocontrol.msvc_payment.payment.domain.model.commands.CreatePaymentCommand;

import java.util.Optional;

public interface PaymentCommandService {
    Optional<Payment> handle(CreatePaymentCommand command);
}
