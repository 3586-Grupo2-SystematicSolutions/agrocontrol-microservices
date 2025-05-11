package com.agrocontrol.msvc_field.fields.interfaces.rest.resources;

public record DeleteWorkerResource(
        Long workerId,
        Long producerId
) {
}
