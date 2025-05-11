package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources;

public record AddCropTreatmentToProcessResource(
        String date,
        String treatmentType,
        Long agriculturalProcessId
) {
}
