package com.agrocontrol.msvc_iam.iam.domain.model.commands;

import com.agrocontrol.msvc_iam.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}