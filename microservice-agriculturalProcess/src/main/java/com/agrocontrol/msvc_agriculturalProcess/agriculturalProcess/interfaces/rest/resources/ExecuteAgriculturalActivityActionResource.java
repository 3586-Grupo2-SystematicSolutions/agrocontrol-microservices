package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources;

public record ExecuteAgriculturalActivityActionResource(
        Long agriculturalProcessId,
        String action
) {
}
