package com.agrocontrol.msvc_profile.profiles.interfaces.rest.transform;

import com.agrocontrol.msvc_profile.profiles.domain.model.aggregates.Distributor;
import com.agrocontrol.msvc_profile.profiles.domain.model.commands.CreateDistributorCommand;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.resource.CreateDistributorResource;

public class CreateDistributorCommandFromResourceAssembler {
    public static CreateDistributorCommand toCommandFromResource(CreateDistributorResource resource) {
        return new CreateDistributorCommand( resource.fullName(), resource.city(), resource.country(),
                resource.phone(), resource.companyName(), resource.ruc() );

    }
}
