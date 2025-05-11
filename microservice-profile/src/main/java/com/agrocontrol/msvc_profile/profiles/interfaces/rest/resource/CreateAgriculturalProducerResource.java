package com.agrocontrol.msvc_profile.profiles.interfaces.rest.resource;

public record CreateAgriculturalProducerResource(
        String fullName,
        String city,
        String country,
        String phone,
        String dni
) {
}
