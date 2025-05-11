package com.agrocontrol.msvc_field.fields.interfaces.rest.resources;

public record FieldResource(
        Long id,
        Long producerId,
        String fieldName,
        String location,
        Integer size

) {
}
