package com.agrocontrol.msvc_iam.iam.interfaces.rest.resources;

public record SignUpDistributorResource(
        String email,
        String password,
        String fullName,
        String city,
        String country,
        String phone,
        String companyName,
        String ruc
) {
}
