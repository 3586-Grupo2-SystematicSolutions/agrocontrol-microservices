package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources;

public record AddIrrigationToProcessResource(
        String date,
        Integer hoursIrrigated,
        Long agriculturalProcessId
) {
}
