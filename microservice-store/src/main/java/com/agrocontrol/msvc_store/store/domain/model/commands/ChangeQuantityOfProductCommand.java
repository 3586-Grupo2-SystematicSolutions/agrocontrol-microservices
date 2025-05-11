package com.agrocontrol.msvc_store.store.domain.model.commands;

public record ChangeQuantityOfProductCommand(
        String action,
        Integer quantity,
        Long productId
) {
}
