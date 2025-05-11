package com.agrocontrol.msvc_payment.payment.application.internal.queryservices;

import com.agrocontrol.msvc_payment.payment.domain.model.aggregates.Payment;
import com.agrocontrol.msvc_payment.payment.domain.model.queries.GetPaymentByIdQuery;
import com.agrocontrol.msvc_payment.payment.domain.model.queries.GetPaymentBySubscriptionIdQuery;
import com.agrocontrol.msvc_payment.payment.domain.services.PaymentQueryService;
import com.agrocontrol.msvc_payment.payment.infrastructure.persistence.jpa.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {
    private final PaymentRepository paymentRepository;
    public PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
}


    @Override
    public Optional<Payment> handle(GetPaymentByIdQuery query) {
        return paymentRepository.findById(query.id());
    }

    @Override
    public Optional<Payment> handle(GetPaymentBySubscriptionIdQuery query) {
        return paymentRepository.findBySubscriptionId(query.subscriptionId());
    }
}
