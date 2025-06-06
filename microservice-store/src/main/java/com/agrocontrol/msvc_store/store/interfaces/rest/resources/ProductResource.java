package com.agrocontrol.msvc_store.store.interfaces.rest.resources;

public record ProductResource(
        Long id,
        Long userId,
        String name,
        String quantityPerUnit,
        double unitPrice,
        Integer quantity,
        String photoUrl
) {
}
