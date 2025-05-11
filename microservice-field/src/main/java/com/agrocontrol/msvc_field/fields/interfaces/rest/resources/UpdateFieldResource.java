package com.agrocontrol.msvc_field.fields.interfaces.rest.resources;

public record UpdateFieldResource(
        String name,
        String location,
        Integer size
) {
}
