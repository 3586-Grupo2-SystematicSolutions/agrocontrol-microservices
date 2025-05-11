package com.agrocontrol.msvc_iam.iam.interfaces.rest.transform;


import com.agrocontrol.msvc_iam.iam.domain.model.aggregates.User;
import com.agrocontrol.msvc_iam.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getEmail(), token, user.getSerializedRoles());
    }
}
