package com.agrocontrol.msvc_field.fields.domain.services;

import com.agrocontrol.msvc_field.fields.domain.model.aggregates.Worker;
import com.agrocontrol.msvc_field.fields.domain.model.queries.GetAllWorkersByProducerId;

import java.util.List;

public interface WorkerQueryService {
    List<Worker> handle(GetAllWorkersByProducerId query);
}
