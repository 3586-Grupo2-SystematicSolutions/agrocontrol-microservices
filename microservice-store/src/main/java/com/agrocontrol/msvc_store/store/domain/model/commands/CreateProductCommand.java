package com.agrocontrol.msvc_store.store.domain.model.commands;

public record CreateProductCommand(Long userId, String name, String quantityPerUnit,
                                   double unitPrice, int quantity, String photoUrl) {
}
