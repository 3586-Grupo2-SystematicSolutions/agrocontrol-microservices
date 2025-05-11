package com.agrocontrol.msvc_field.fields.interfaces.rest.transform;

import com.agrocontrol.msvc_field.fields.domain.model.aggregates.Worker;
import com.agrocontrol.msvc_field.fields.interfaces.rest.resources.WorkerResource;

public class WorkerResourceFromEntityAssembler {
    public static WorkerResource toResourceFromEntity(Worker entity) {
        return new WorkerResource(
                entity.getId(),
                entity.getProducerId(),
                entity.getFullName(),
                entity.getDocumentNumber()
        );
    }
}
