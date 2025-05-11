package com.agrocontrol.msvc_profile.profiles.interfaces.rest.transform;

import com.agrocontrol.msvc_profile.profiles.domain.model.aggregates.AgriculturalProducer;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.resource.AgriculturalProducerResource;

public class AgriculturalProducerResourceFromEntityAssembler {
    public static AgriculturalProducerResource toResourceFromEntity(AgriculturalProducer agriculturalProducer) {
        return new AgriculturalProducerResource(
                agriculturalProducer.getUserId(), agriculturalProducer.getId(), agriculturalProducer.getFullName(),
                agriculturalProducer.getCity(), agriculturalProducer.getCountry(), agriculturalProducer.getPhone(),
                agriculturalProducer.getDni()
        );
    }
}
