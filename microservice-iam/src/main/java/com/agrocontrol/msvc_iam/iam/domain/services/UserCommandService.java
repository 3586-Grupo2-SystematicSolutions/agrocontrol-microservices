package com.agrocontrol.msvc_iam.iam.domain.services;

import com.agrocontrol.msvc_iam.iam.domain.model.aggregates.User;
import com.agrocontrol.msvc_iam.iam.domain.model.commands.RefreshTokenCommand;
import com.agrocontrol.msvc_iam.iam.domain.model.commands.SignInCommand;
import com.agrocontrol.msvc_iam.iam.domain.model.commands.SignUpAgriculturalProducerCommand;
import com.agrocontrol.msvc_iam.iam.domain.model.commands.SignUpDistributorCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;


public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    //Optional<User> handle(SignUpCommand command);
    Optional<User> handle(SignUpAgriculturalProducerCommand command);
    Optional<User> handle(SignUpDistributorCommand command);
    Optional<ImmutablePair<User, String>> handle(RefreshTokenCommand command);

}
