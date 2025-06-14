package com.agrocontrol.msvc_field.fields.application.internal.commandservices;

import com.agrocontrol.msvc_field.fields.application.internal.outboundservices.acl.ExternalProfileService;
import com.agrocontrol.msvc_field.fields.domain.exceptions.FieldNotFoundException;
import com.agrocontrol.msvc_field.fields.domain.model.aggregates.Field;
import com.agrocontrol.msvc_field.fields.domain.model.commands.CreateFieldCommand;
import com.agrocontrol.msvc_field.fields.domain.model.commands.DeleteFieldCommand;
import com.agrocontrol.msvc_field.fields.domain.model.commands.UpdateFieldCommand;
import com.agrocontrol.msvc_field.fields.domain.model.valueobjects.ProducerId;
import com.agrocontrol.msvc_field.fields.domain.services.FieldCommandService;
import com.agrocontrol.msvc_field.fields.infrastructure.persistence.jpa.repositories.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FieldCommandServiceImpl implements FieldCommandService {
    private final FieldRepository fieldRepository;
    private final ExternalProfileService externalProfileService;

    public FieldCommandServiceImpl(FieldRepository fieldRepository, ExternalProfileService externalProfileService) {
        this.fieldRepository = fieldRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Optional<Field> handle(CreateFieldCommand command) {
        externalProfileService.existsAgriculturalProducer(command.producerId()).join();
        var field = new Field(command);
        var fieldCreated = fieldRepository.save(field);
        return Optional.of(fieldCreated);
    }

    @Override
    public Optional<Field> handle(UpdateFieldCommand command) {
        var field = this.fieldRepository.findById(command.FieldId())
                .orElseThrow(() -> new FieldNotFoundException(command.FieldId()));
        field.updateField(command);
        var fieldUpdated = fieldRepository.save(field);
        return Optional.of(fieldUpdated);
    }

    @Override
    public void handle(DeleteFieldCommand command) {
        externalProfileService.existsAgriculturalProducer(command.producerId()).join();
        var producerId = new ProducerId(command.producerId());


        var field = this.fieldRepository.findByIdAndProducerId(command.fieldId(), producerId)
                .orElseThrow(() -> new FieldNotFoundException(command.fieldId()));


        this.fieldRepository.delete(field);
    }
}
