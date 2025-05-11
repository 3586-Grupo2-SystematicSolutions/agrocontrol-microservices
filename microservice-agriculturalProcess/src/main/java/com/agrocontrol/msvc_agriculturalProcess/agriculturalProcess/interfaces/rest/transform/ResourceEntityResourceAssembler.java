package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.transform;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.valueobjects.Resource;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.rest.resources.ResourceEntityResource;

public class ResourceEntityResourceAssembler {
    public static ResourceEntityResource toResourceFromEntity(Resource entity) {
        return new ResourceEntityResource(
                entity.getResourceId(),
                entity.getName(),
                entity.getCost(),
                entity.getQuantity()
        );
    }
}
