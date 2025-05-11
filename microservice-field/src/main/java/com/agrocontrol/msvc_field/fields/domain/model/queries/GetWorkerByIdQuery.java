package com.agrocontrol.msvc_field.fields.domain.model.queries;

public record GetWorkerByIdQuery(Long workerId) {
    public GetWorkerByIdQuery {
        if (workerId == null || workerId <= 0) {
            throw new IllegalArgumentException("workerId must be greater than 0");
        }
    }
}
