package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.transform;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.aggregates.AgriculturalProcess;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources.AgriculturalProcessResource;

public class AgriculturalProcessResourceFromEntityAssembler {
    public static AgriculturalProcessResource toResourceFromEntity(AgriculturalProcess entity) {

        return new AgriculturalProcessResource(
                entity.getId(),
                entity.getFieldId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.isFinished()
        );
    }
}
