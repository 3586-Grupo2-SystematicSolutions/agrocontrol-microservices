package com.agrocontrol.msvc_field.fields.interfaces.rest.transform;

import com.agrocontrol.msvc_field.fields.domain.model.commands.DeleteFieldCommand;
import com.agrocontrol.msvc_field.fields.interfaces.rest.resources.DeleteFieldResource;

//TODO:Documentation
public class DeleteFieldCommandFromResourceAssembler {
    public static DeleteFieldCommand toCommandFromResource(DeleteFieldResource resource, Long id) {
        return new DeleteFieldCommand(
                id,
                resource.producerId()
        );
    }
}
