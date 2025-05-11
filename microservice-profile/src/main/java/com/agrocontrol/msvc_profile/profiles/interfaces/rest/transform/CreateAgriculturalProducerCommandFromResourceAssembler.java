package com.agrocontrol.msvc_profile.profiles.interfaces.rest.transform;


import com.agrocontrol.msvc_profile.profiles.domain.model.commands.CreateAgriculturalProducerCommand;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.resource.CreateAgriculturalProducerResource;

public class CreateAgriculturalProducerCommandFromResourceAssembler {
    public static CreateAgriculturalProducerCommand toCommandFromResource(CreateAgriculturalProducerResource resource) {
        return new CreateAgriculturalProducerCommand( resource.fullName(),  resource.city(),
                resource.country(), resource.phone(), resource.dni() );
    }
}
