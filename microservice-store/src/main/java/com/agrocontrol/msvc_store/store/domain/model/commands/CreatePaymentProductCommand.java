package com.agrocontrol.msvc_store.store.domain.model.commands;

public record CreatePaymentProductCommand(
        Long productId,
        Integer quantityProduct,
        Long userId
) {
}
