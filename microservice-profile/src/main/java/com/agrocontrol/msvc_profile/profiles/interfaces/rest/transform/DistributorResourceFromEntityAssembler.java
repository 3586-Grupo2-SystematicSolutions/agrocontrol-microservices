package com.agrocontrol.msvc_profile.profiles.interfaces.rest.transform;

import com.agrocontrol.msvc_profile.profiles.domain.model.aggregates.Distributor;
import com.agrocontrol.msvc_profile.profiles.interfaces.rest.resource.DistributorResource;

public class DistributorResourceFromEntityAssembler {
    public static DistributorResource toResourceFromEntity(Distributor distributor) {
        return new DistributorResource(
                distributor.getUserId(), distributor.getId(), distributor.getFullName(), distributor.getCity(),
                distributor.getCountry(), distributor.getPhone(), distributor.getCompanyName(), distributor.getRuc()
        );
    }
}
