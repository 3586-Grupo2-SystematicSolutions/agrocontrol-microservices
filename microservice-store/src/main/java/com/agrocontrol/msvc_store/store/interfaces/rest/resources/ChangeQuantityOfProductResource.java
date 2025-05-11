package com.agrocontrol.msvc_store.store.interfaces.rest.resources;

public record ChangeQuantityOfProductResource(
        String action,
        Integer quantity
) {
}
