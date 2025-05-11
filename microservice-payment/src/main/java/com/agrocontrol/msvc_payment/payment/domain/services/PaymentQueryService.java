package com.agrocontrol.msvc_payment.payment.domain.services;

import com.agrocontrol.msvc_payment.payment.domain.model.aggregates.Payment;
import com.agrocontrol.msvc_payment.payment.domain.model.queries.GetPaymentByIdQuery;
import com.agrocontrol.msvc_payment.payment.domain.model.queries.GetPaymentBySubscriptionIdQuery;

import java.util.Optional;

public interface PaymentQueryService {
    Optional<Payment> handle(GetPaymentByIdQuery query);
    Optional<Payment> handle(GetPaymentBySubscriptionIdQuery query);

}
