package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands;

public record AddIrrigationToProcessCommand(
        String date,
        Integer hoursIrrigated,
        Long agriculturalProcessId
){
}
