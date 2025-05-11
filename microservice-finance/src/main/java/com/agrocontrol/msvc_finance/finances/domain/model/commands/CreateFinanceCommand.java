package com.agrocontrol.msvc_finance.finances.domain.model.commands;

public record CreateFinanceCommand(
        Long agriculturalProcessId,
        String type,
        String description,
        double value
) {
}
