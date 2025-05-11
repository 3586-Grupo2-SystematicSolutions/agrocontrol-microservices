package com.agrocontrol.msvc_field.fields.interfaces.rest.transform;

import com.agrocontrol.msvc_field.fields.domain.model.aggregates.Field;
import com.agrocontrol.msvc_field.fields.interfaces.rest.resources.FieldResource;

//TODO: Documentation
public class FieldResourceFromEntityAssembler {
    public static FieldResource toResourceFromEntity(Field field) {
        return new FieldResource(
                field.getId(),
                field.getProducerId(),
                field.getFieldName(),
                field.getLocation(),
                field.getSize()
        );
    }
}
