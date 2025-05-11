package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands;

public record AddCropTreatmentToProcessCommand(
        String date,
        String treatmentType,
        Long agriculturalProcessId
) {
}
