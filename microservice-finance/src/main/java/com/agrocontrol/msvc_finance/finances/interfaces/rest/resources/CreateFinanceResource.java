package com.agrocontrol.msvc_finance.finances.interfaces.rest.resources;

public record CreateFinanceResource(
        Long agriculturalProcessId,
        String type,
        String description,
        double value
) {
}
