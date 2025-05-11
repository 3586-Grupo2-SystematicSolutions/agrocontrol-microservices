package com.agrocontrol.msvc_iam.iam.interfaces.rest.transform;

import com.agrocontrol.msvc_iam.iam.domain.model.entities.Role;
import com.agrocontrol.msvc_iam.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}