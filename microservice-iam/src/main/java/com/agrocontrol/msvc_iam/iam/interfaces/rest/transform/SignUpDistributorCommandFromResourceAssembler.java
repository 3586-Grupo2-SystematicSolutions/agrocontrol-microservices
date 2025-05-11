package com.agrocontrol.msvc_iam.iam.interfaces.rest.transform;

import com.agrocontrol.msvc_iam.iam.domain.model.commands.SignUpDistributorCommand;
import com.agrocontrol.msvc_iam.iam.interfaces.rest.resources.SignUpDistributorResource;

public class SignUpDistributorCommandFromResourceAssembler {
    public static SignUpDistributorCommand toCommandFromResource(SignUpDistributorResource resource) {
        return new SignUpDistributorCommand(resource.fullName(), resource.email() ,resource.password(),
                resource.city(), resource.country(), resource.phone(), resource.companyName(),resource.ruc());
    }
}
