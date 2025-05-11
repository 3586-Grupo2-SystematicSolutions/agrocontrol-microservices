package com.agrocontrol.msvc_field.fields.interfaces.rest.transform;

import com.agrocontrol.msvc_field.fields.domain.model.commands.CreateFieldCommand;
import com.agrocontrol.msvc_field.fields.interfaces.rest.resources.CreateFieldResource;

//TODO: Documentation
public class CreateFieldCommandFromFieldResourceAssembler {
    public static CreateFieldCommand toCommandFromFieldResource(CreateFieldResource resource) {
        return new CreateFieldCommand(
                resource.producerId(),
                resource.fieldName(),
                resource.location(),
                resource.size()
        );
    }

}
