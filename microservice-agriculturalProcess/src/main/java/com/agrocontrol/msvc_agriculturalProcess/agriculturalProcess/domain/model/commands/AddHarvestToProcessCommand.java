package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands;

public record AddHarvestToProcessCommand(
        String date,
        double quantityInKg,
        double pricePerKg,
        Long agriculturalProcessId
) {
}
