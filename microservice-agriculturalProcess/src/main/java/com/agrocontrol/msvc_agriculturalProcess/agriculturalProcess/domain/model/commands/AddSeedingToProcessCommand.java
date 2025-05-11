package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands;

public record AddSeedingToProcessCommand(
        String date,
        String plantType,
        Integer quantityPlanted,
        Long agriculturalProcessId
) {
}
