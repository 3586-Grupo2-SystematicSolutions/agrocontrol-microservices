package com.agrocontrol.msvc_field.fields.domain.services;

import com.agrocontrol.msvc_field.fields.domain.model.aggregates.Worker;
import com.agrocontrol.msvc_field.fields.domain.model.commands.CreateWorkerCommand;
import com.agrocontrol.msvc_field.fields.domain.model.commands.DeleteWorkerCommand;

import java.util.Optional;

public interface WorkerCommandService {
    Optional<Worker> handle(CreateWorkerCommand command);

    void handle(DeleteWorkerCommand command);
}
