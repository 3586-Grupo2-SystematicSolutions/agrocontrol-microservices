package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.application.internal.commandservices;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.application.internal.outboundservices.acl.ExternalFinanceService;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.application.internal.outboundservices.acl.ExternalStoreService;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.application.internal.outboundservices.acl.ExternalFieldService;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.aggregates.AgriculturalProcess;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.commands.*;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.valueobjects.AgriculturalActivity;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.services.AgriculturalProcessCommandService;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.infrastructure.persistence.jpa.repositories.AgriculturalProcessRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgriculturalProcessCommandServiceImpl implements AgriculturalProcessCommandService {
    private final AgriculturalProcessRepository agriculturalProcessRepository;
    private final ExternalFinanceService externalFinanceService;
    private final ExternalStoreService externalStoreService;
    private final ExternalFieldService externalFieldService;

    public AgriculturalProcessCommandServiceImpl(AgriculturalProcessRepository agriculturalProcessRepository,
                                                 ExternalFinanceService externalFinanceService, ExternalStoreService externalStoreService, ExternalFieldService externalFieldService) {
        this.agriculturalProcessRepository = agriculturalProcessRepository;
        this.externalFinanceService = externalFinanceService;
        this.externalStoreService = externalStoreService;
        this.externalFieldService = externalFieldService;
    }

    @Override
    public Optional<AgriculturalProcess> handle(CreateAgriculturalProcessCommand command) {
        var agriculturalProcess = new AgriculturalProcess(command);
        var createdAgriculturalProcess = agriculturalProcessRepository.save(agriculturalProcess);
        return Optional.of(createdAgriculturalProcess);
    }

    @Override
    public Optional<AgriculturalActivity> handle(AddSeedingToProcessCommand command) {
        AgriculturalProcess agriculturalProcess = this.agriculturalProcessRepository.findById(command.agriculturalProcessId())
                .orElseThrow(() -> new IllegalArgumentException("Agricultural Process not found"));

        agriculturalProcess.addActivity(command);
        var updatedAgriculturalProcess = agriculturalProcessRepository.save(agriculturalProcess);
        return Optional.ofNullable(updatedAgriculturalProcess.getLastActivityId());
    }

    @Override
    public Optional<AgriculturalActivity> handle(AddIrrigationToProcessCommand command) {
        AgriculturalProcess agriculturalProcess = this.agriculturalProcessRepository.findById(command.agriculturalProcessId())
                .orElseThrow(() -> new IllegalArgumentException("Agricultural Process not found"));

        if (agriculturalProcess.isFinished()) {
            throw new IllegalArgumentException("Agricultural Process is already finished");
        }

        agriculturalProcess.addActivity(command);
        var updatedAgriculturalProcess = agriculturalProcessRepository.save(agriculturalProcess);
        return Optional.ofNullable(updatedAgriculturalProcess.getLastActivityId());
    }

    @Override
    public Optional<AgriculturalActivity> handle(AddCropTreatmentToProcessCommand command) {
        AgriculturalProcess agriculturalProcess = this.agriculturalProcessRepository.findById(command.agriculturalProcessId())
                .orElseThrow(() -> new IllegalArgumentException("Agricultural Process not found"));

        if (agriculturalProcess.isFinished()) {
            throw new IllegalArgumentException("Agricultural Process is already finished");
        }

        agriculturalProcess.addActivity(command);
        var updatedAgriculturalProcess = agriculturalProcessRepository.save(agriculturalProcess);
        return Optional.ofNullable(updatedAgriculturalProcess.getLastActivityId());
    }

    @Override
    public Optional<AgriculturalActivity> handle(AddHarvestToProcessCommand command) {
        var agriculturalProcess = this.agriculturalProcessRepository.findById(command.agriculturalProcessId())
                .orElseThrow(() -> new IllegalArgumentException("Agricultural Process not found"));

        if (agriculturalProcess.isFinished()) {
            throw new IllegalArgumentException("Agricultural Process is already finished");
        }

        agriculturalProcess.addActivity(command);

        var updatedAgriculturalProcess = agriculturalProcessRepository.save(agriculturalProcess);

        var subTotal = command.pricePerKg() * command.quantityInKg();

        this.externalFinanceService.createFinance(agriculturalProcess.getId(), "INCOME",
                "Harvest day: " + command.date(), subTotal).join();

        return Optional.ofNullable(updatedAgriculturalProcess.getLastActivityId());
    }

    @Override
    public Optional<AgriculturalProcess> handle(FinishAgriculturalProcessCommand command) {
        AgriculturalProcess agriculturalProcess = this.agriculturalProcessRepository.findById(command.agriculturalProcessId())
                .orElseThrow(() -> new IllegalArgumentException("Agricultural Process not found"));

        if (agriculturalProcess.isFinished()) {
            throw new IllegalArgumentException("Agricultural Process is already finished");
        }

        agriculturalProcess.finish();
        var updatedAgriculturalProcess = agriculturalProcessRepository.save(agriculturalProcess);
        return Optional.of(updatedAgriculturalProcess);
    }

    @Override
    public Optional<AgriculturalActivity> handle(ExecuteAgriculturalActivityActionCommand command) {
        var agriculturalProcess = this.agriculturalProcessRepository.findById(command.agriculturalProcessId())
                .orElseThrow(() -> new IllegalArgumentException("Agricultural Process not found"));

        if (agriculturalProcess.isFinished()) {
            throw new IllegalArgumentException("Agricultural Process is already finished");
        }
        agriculturalProcess.applyActivityAction(command);
        var updatedAgriculturalProcess = agriculturalProcessRepository.save(agriculturalProcess);
        return Optional.ofNullable(updatedAgriculturalProcess.getActivityById(command.activityId()));
    }

    @Override
    public Optional<AgriculturalActivity> handle(AddResourceToActivityCommand command) {
        var agriculturalProcess = this.agriculturalProcessRepository.findById(command.agriculturalProcessId())
                .orElseThrow(() -> new IllegalArgumentException("Agricultural Process not found"));

        if (agriculturalProcess.isFinished()) {
            throw new IllegalArgumentException("Agricultural Process is already finished");
        }       

        String name = "";
        if (command.cost() > 0) {
            name = this.externalFieldService.getWorkerNameById(command.resourceId()).join();
            this.externalFinanceService.createFinance(agriculturalProcess.getId(), "EXPENSE",
                    command.description(), command.cost()).join();
        } else if (command.quantity() > 0) {
            name = String.valueOf(this.externalStoreService.getProductNameById(command.resourceId()).join());
            this.externalStoreService.changeQuantityOfProduct(command.resourceId(), command.quantity()).join();
        } else {
            name = "Resource";
        }

        agriculturalProcess.addResourceToActivity(command, name);

        var updatedAgriculturalProcess = agriculturalProcessRepository.save(agriculturalProcess);
        return Optional.ofNullable(updatedAgriculturalProcess.getActivityById(command.activityId()));
    }
}
