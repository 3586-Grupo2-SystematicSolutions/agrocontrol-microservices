package com.agrocontrol.msvc_field.fields.application.internal.commandservices;

import com.agrocontrol.msvc_field.fields.application.internal.outboundservices.acl.ExternalProfileService;
import com.agrocontrol.msvc_field.fields.domain.model.aggregates.Worker;
import com.agrocontrol.msvc_field.fields.domain.model.commands.CreateWorkerCommand;
import com.agrocontrol.msvc_field.fields.domain.model.commands.DeleteWorkerCommand;
import com.agrocontrol.msvc_field.fields.domain.model.valueobjects.ProducerId;
import com.agrocontrol.msvc_field.fields.domain.services.WorkerCommandService;
import com.agrocontrol.msvc_field.fields.infrastructure.persistence.jpa.repositories.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkerCommandServiceImpl implements WorkerCommandService {
    private final WorkerRepository workerRepository;
    private final ExternalProfileService externalProfileService;

    public WorkerCommandServiceImpl(WorkerRepository workerRepository, ExternalProfileService externalProfileService) {
        this.workerRepository = workerRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Optional<Worker> handle(CreateWorkerCommand command) {
        externalProfileService.exitsAgriculturalProducer(command.producerId());

        var worker = new Worker(command);
        var workerCreated = workerRepository.save(worker);

        return Optional.of(workerCreated);
    }

    @Override
    public void handle(DeleteWorkerCommand command) {
        var producerId = new ProducerId(command.producerId());

        var worker = this.workerRepository.findByIdAndProducerId(command.workerId(), producerId)
                .orElseThrow(()->new IllegalArgumentException("Worker not found"));

        this.workerRepository.delete(worker);
    }
}
