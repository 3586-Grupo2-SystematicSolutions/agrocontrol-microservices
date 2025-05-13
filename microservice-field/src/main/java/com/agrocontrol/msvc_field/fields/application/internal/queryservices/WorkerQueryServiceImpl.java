package com.agrocontrol.msvc_field.fields.application.internal.queryservices;

import com.agrocontrol.msvc_field.fields.application.internal.outboundservices.acl.ExternalProfileService;
import com.agrocontrol.msvc_field.fields.domain.model.aggregates.Worker;
import com.agrocontrol.msvc_field.fields.domain.model.queries.GetAllWorkersByProducerId;
import com.agrocontrol.msvc_field.fields.domain.model.queries.GetFullnameByWorkerId;
import com.agrocontrol.msvc_field.fields.domain.model.valueobjects.ProducerId;
import com.agrocontrol.msvc_field.fields.domain.services.WorkerQueryService;
import com.agrocontrol.msvc_field.fields.infrastructure.persistence.jpa.repositories.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerQueryServiceImpl implements WorkerQueryService {
    public final WorkerRepository workerRepository;
    private final ExternalProfileService externalProfileService;

    public WorkerQueryServiceImpl(WorkerRepository workerRepository,
                                  ExternalProfileService externalProfileService) {
        this.workerRepository = workerRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public List<Worker> handle(GetAllWorkersByProducerId query) {
        externalProfileService.exitsAgriculturalProducer(query.producerId());
        var producerId = new ProducerId(query.producerId());
        return this.workerRepository.findAllByProducerId(producerId);
    }

    @Override
    public Optional<Worker> findFullNameById(GetFullnameByWorkerId query) {
        return this.workerRepository.findFullNameById(query.workerId());
    }
}
