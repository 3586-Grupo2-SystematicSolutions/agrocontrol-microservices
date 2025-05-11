package com.agrocontrol.msvc_field.fields.interfaces.rest.resources;

public record CreateWorkerResource(
        Long producerId,
        String fullName,
        String documentNumber
) {
}
