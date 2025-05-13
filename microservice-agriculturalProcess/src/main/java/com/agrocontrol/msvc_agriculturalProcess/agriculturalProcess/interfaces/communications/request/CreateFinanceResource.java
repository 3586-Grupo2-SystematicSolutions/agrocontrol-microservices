package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.request;

public record CreateFinanceResource(
        Long agriculturalProcessId,
        String type,
        String description,
        double value
) {
}
