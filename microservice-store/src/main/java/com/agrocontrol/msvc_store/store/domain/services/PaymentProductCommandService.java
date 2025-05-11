package com.agrocontrol.msvc_store.store.domain.services;

import com.agrocontrol.msvc_store.store.domain.model.aggregates.PaymentProduct;
import com.agrocontrol.msvc_store.store.domain.model.commands.CreatePaymentProductCommand;

import java.util.Optional;

public interface PaymentProductCommandService {
    Optional<PaymentProduct> handle(CreatePaymentProductCommand command);
}
