package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources;

public record AddSeedingToProcessResource(
        String date,
        String plantType,
        Integer quantityPlanted,
        Long agriculturalProcessId
) {
}
