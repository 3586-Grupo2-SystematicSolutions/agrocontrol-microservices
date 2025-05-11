package com.agrocontrol.msvc_store.store.interfaces.rest.resources;

public record UpdateProductResource(
        String name,
        String quantityPerUnit,
        double unitPrice,
        Integer quantity,
        String photoUrl
) {
}
