package com.agrocontrol.msvc_iam.iam.interfaces.rest.transform;

import com.agrocontrol.msvc_iam.iam.domain.model.commands.SignInCommand;
import com.agrocontrol.msvc_iam.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.email(), signInResource.password());
    }
}
