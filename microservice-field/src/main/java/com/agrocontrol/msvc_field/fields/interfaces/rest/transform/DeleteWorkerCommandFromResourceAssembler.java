package com.agrocontrol.msvc_field.fields.interfaces.rest.transform;

import com.agrocontrol.msvc_field.fields.domain.model.commands.DeleteWorkerCommand;
import com.agrocontrol.msvc_field.fields.interfaces.rest.resources.DeleteWorkerResource;

public class DeleteWorkerCommandFromResourceAssembler {
    public static DeleteWorkerCommand toCommandFromResource(DeleteWorkerResource resource) {
        return new DeleteWorkerCommand(
                resource.producerId(),
                resource.workerId()
        );
    }
}
