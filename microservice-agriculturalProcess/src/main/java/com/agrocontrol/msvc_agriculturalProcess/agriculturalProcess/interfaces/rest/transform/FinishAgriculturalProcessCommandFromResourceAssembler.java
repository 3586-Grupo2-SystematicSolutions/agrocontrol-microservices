package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.transform;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands.FinishAgriculturalProcessCommand;

public class FinishAgriculturalProcessCommandFromResourceAssembler {
    public static FinishAgriculturalProcessCommand toCommandFromResource(Long id) {
        return new FinishAgriculturalProcessCommand(
                id
        );
    }
}
