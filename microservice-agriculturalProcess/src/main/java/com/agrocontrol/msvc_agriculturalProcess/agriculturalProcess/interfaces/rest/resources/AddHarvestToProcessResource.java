package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources;

public record AddHarvestToProcessResource(
        String date,
        double quantityInKg,
        double pricePerKg,
        Long agriculturalProcessId
) {
}