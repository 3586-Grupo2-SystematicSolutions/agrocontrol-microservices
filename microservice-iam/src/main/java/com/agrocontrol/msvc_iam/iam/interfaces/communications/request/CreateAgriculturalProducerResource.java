package com.agrocontrol.msvc_iam.iam.interfaces.communications.request;

public record CreateAgriculturalProducerResource(
        String fullName,
        String city,
        String country,
        String phone,
        String dni
) {
}
