package com.agrocontrol.msvc_profile.profiles.interfaces.rest.resource;

public record DistributorResource(
        Long userId,
        Long distributorId,
        String fullName,
        String city,
        String country,
        String phone,
        String companyName,
        String ruc
) {
}
