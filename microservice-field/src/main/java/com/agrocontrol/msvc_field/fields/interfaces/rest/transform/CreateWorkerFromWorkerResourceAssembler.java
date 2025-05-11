package com.agrocontrol.msvc_field.fields.interfaces.rest.transform;

import com.agrocontrol.msvc_field.fields.domain.model.commands.CreateWorkerCommand;
import com.agrocontrol.msvc_field.fields.interfaces.rest.resources.CreateWorkerResource;

public class CreateWorkerFromWorkerResourceAssembler {
    public static CreateWorkerCommand toCommandFromWorkerResource(CreateWorkerResource resource) {
        return new CreateWorkerCommand(
                resource.producerId(),
                resource.fullName(),
                resource.documentNumber()
        );
    }
}
