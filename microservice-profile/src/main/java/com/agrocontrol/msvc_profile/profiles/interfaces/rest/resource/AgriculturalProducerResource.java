package com.agrocontrol.msvc_profile.profiles.interfaces.rest.resource;

public record AgriculturalProducerResource(
        Long userId,
        Long agriculturalProducerId,
        String fullName,
        String city,
        String country,
        String phone,
        String dni
) {
}
