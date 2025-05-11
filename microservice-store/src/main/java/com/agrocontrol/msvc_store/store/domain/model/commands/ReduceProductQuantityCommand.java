package com.agrocontrol.msvc_store.store.domain.model.commands;

public record ReduceProductQuantityCommand(Long productId, Integer quantityToReduce) {
}
