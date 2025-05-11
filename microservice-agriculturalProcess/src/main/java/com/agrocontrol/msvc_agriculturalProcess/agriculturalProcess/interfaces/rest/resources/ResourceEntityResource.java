package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources;

public record ResourceEntityResource(
        Long resourceId,
        String name,
        Integer cost,
        Integer quantity
) {
}
