package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands;

public record ExecuteAgriculturalActivityActionCommand(
        Long agriculturalProcessId,
        Long activityId,
        String action
) {
}
