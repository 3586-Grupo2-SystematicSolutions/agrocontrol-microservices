package com.agrocontrol.msvc_iam.iam.interfaces.rest.transform;

import com.agrocontrol.msvc_iam.iam.domain.model.commands.SignUpAgriculturalProducerCommand;
import com.agrocontrol.msvc_iam.iam.interfaces.rest.resources.SignUpAgriculturalProducerResource;

public class SignUpAgriculturalProducerCommandFromResourceAssembler{
    public static SignUpAgriculturalProducerCommand toCommandFromResource(SignUpAgriculturalProducerResource resource) {
        return new SignUpAgriculturalProducerCommand(resource.fullName(), resource.email() ,resource.password(),
                resource.city(), resource.country(), resource.phone(), resource.dni());
    }
}
