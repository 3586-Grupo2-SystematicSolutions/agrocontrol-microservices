package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources;

import java.time.LocalDate;

public record AgriculturalProcessResource(
        Long id,
        Long fieldId,
        LocalDate startDate,
        LocalDate endDate,
        boolean isFinished
) {
}
