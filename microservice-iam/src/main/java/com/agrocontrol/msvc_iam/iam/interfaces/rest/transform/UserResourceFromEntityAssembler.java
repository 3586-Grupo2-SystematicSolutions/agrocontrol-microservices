package com.agrocontrol.msvc_iam.iam.interfaces.rest.transform;


import com.agrocontrol.msvc_iam.iam.domain.model.aggregates.User;
import com.agrocontrol.msvc_iam.iam.domain.model.entities.Role;
import com.agrocontrol.msvc_iam.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(user.getId(), user.getEmail(), roles);
    }
}