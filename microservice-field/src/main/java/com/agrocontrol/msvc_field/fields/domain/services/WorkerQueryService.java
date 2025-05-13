package com.agrocontrol.msvc_field.fields.domain.services;

import com.agrocontrol.msvc_field.fields.domain.model.aggregates.Worker;
import com.agrocontrol.msvc_field.fields.domain.model.queries.GetAllWorkersByProducerId;
import com.agrocontrol.msvc_field.fields.domain.model.queries.GetFullnameByWorkerId;
import com.agrocontrol.msvc_field.fields.domain.model.valueobjects.ProducerId;

import java.util.List;
import java.util.Optional;

public interface WorkerQueryService {
    List<Worker> handle(GetAllWorkersByProducerId query);
    Optional<Worker> findFullNameById(GetFullnameByWorkerId query);
}
