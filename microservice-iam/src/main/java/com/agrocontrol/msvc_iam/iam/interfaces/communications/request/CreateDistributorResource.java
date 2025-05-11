package com.agrocontrol.msvc_iam.iam.interfaces.communications.request;

public record CreateDistributorResource(
        String fullName,
        String city,
        String country,
        String phone,
        String companyName,
        String ruc
) {
}
