package com.agrocontrol.msvc_field.fields.application.internal.queryservices;

import com.agrocontrol.msvc_field.fields.application.internal.outboundservices.acl.ExternalProfileService;
import com.agrocontrol.msvc_field.fields.domain.model.aggregates.Field;
import com.agrocontrol.msvc_field.fields.domain.model.queries.GetFieldByIdQuery;
import com.agrocontrol.msvc_field.fields.domain.model.queries.GetFieldsByProducerIdQuery;
import com.agrocontrol.msvc_field.fields.domain.model.valueobjects.ProducerId;
import com.agrocontrol.msvc_field.fields.domain.services.FieldQueryService;
import com.agrocontrol.msvc_field.fields.infrastructure.persistence.jpa.repositories.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FieldQueryServiceImpl implements FieldQueryService {
    public final FieldRepository fieldRepository;
    private final ExternalProfileService externalProfileService;

    public FieldQueryServiceImpl(FieldRepository fieldRepository,
                                 ExternalProfileService externalProfileService) {
        this.fieldRepository = fieldRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Optional<Field> handle(GetFieldByIdQuery query) {
        return this.fieldRepository.findById(query.fieldId());
    }

    @Override
    public List<Field> handle(GetFieldsByProducerIdQuery query) {
        externalProfileService.existsAgriculturalProducer(query.producerId()).join();
        ProducerId producerId = new ProducerId(query.producerId());


        return this.fieldRepository.findByProducerId(producerId);
    }


}
