package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.request;

public record ChangeQuantityOfProductResource(
        String action,
        Integer quantity
) {
}
