package com.agrocontrol.msvc_iam.iam.application.internal.commandservices;



import com.agrocontrol.msvc_iam.iam.application.internal.outboundservices.acl.ExternalProfileService;
import com.agrocontrol.msvc_iam.iam.application.internal.outboundservices.hashing.HashingService;
import com.agrocontrol.msvc_iam.iam.application.internal.outboundservices.tokens.TokenService;
import com.agrocontrol.msvc_iam.iam.domain.model.aggregates.User;
import com.agrocontrol.msvc_iam.iam.domain.model.commands.RefreshTokenCommand;
import com.agrocontrol.msvc_iam.iam.domain.model.commands.SignInCommand;
import com.agrocontrol.msvc_iam.iam.domain.model.commands.SignUpAgriculturalProducerCommand;
import com.agrocontrol.msvc_iam.iam.domain.model.commands.SignUpDistributorCommand;
import com.agrocontrol.msvc_iam.iam.domain.model.entities.Role;
import com.agrocontrol.msvc_iam.iam.domain.model.valueobjects.Roles;
import com.agrocontrol.msvc_iam.iam.domain.services.UserCommandService;
import com.agrocontrol.msvc_iam.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.agrocontrol.msvc_iam.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;
    private final ExternalProfileService externalProfileService;

    public UserCommandServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                                  HashingService hashingService, TokenService tokenService,
                                  ExternalProfileService externalProfileService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email());
        if (user.isEmpty())
            throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.get().getEmail());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }

    @Override
    @Transactional
    public Optional<User> handle(SignUpAgriculturalProducerCommand command) {
        if (userRepository.existsByEmail(command.email()))
            throw new RuntimeException("Email already exists");

        // Buscar el rol de desarrollador en el repositorio de roles
        Role agriculturalProducerRole = roleRepository.findByName(Roles.valueOf("ROLE_AGRICULTURAL_PRODUCER"))
                .orElseThrow(() -> new RuntimeException("Agricultural Producer role not found"));

        // Crear una lista con el rol de desarrollador
        List<Role> roles = List.of(agriculturalProducerRole);

        // Crear el usuario con el rol de agricultural producer
        var user = new User(command.email(), hashingService.encode(command.password()), roles);
        userRepository.save(user);

        Long agriculturalProducerId = externalProfileService.createAgriculturalProducer(
                command.fullName(), command.city(), command.country(),
                command.phone(), command.dni(), user.getId()
        ).join();

        if (agriculturalProducerId == 0L) {
            throw new RuntimeException("Failed to create AgriculturalProducer profile");
        }

        return Optional.of(user);
    }

    @Override
    @Transactional
    public Optional<User> handle(SignUpDistributorCommand command) {
        if (userRepository.existsByEmail(command.email()))
            throw new RuntimeException("Email already exists");

        // Buscar el rol de desarrollador en el repositorio de roles
        Role distributorRole = roleRepository.findByName(Roles.valueOf("ROLE_DISTRIBUTOR"))
                .orElseThrow(() -> new RuntimeException("Distributor role not found"));

        // Crear una lista con el rol de desarrollador
        List<Role> roles = List.of(distributorRole);

        // Crear el usuario con el rol de distribuidor
        var user = new User(command.email(), hashingService.encode(command.password()), roles);
        userRepository.save(user);

        Long distributorId = externalProfileService.createDistributor(
                command.fullName(), command.city(), command.country(),
                command.phone(), command.companyName(), command.ruc(), user.getId()
        ).join();

        if (distributorId == 0L) {
            throw new RuntimeException("Failed to create Distributor profile");
        }

        return Optional.of(user);
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(RefreshTokenCommand command) {
        String username = tokenService.getUsernameFromToken(command.token());
        var user = userRepository.findByEmail(username);
        if (user.isEmpty()) throw new RuntimeException("User not found");
        var token = tokenService.generateToken(user.get().getEmail());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }
}
