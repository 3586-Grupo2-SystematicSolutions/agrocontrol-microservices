package com.agrocontrol.msvc_field.fields.interfaces.rest.resources;

/**
 * Resource class for creating a new field
 */
public record CreateFieldResource(
        Long producerId,
        String fieldName,
        String location,
        Integer size
) {
}
