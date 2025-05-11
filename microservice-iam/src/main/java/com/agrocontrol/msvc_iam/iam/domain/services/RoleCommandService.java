package com.agrocontrol.msvc_iam.iam.domain.services;

import com.agrocontrol.msvc_iam.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
