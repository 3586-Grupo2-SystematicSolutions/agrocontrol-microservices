package com.agrocontrol.msvc_iam.iam.application.internal.queryservices;

import com.agrocontrol.msvc_iam.iam.domain.model.entities.Role;
import com.agrocontrol.msvc_iam.iam.domain.model.queries.GetAllRolesQuery;
import com.agrocontrol.msvc_iam.iam.domain.model.queries.GetRoleByNameQuery;
import com.agrocontrol.msvc_iam.iam.domain.services.RoleQueryService;
import com.agrocontrol.msvc_iam.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    /**
     * RoleQueryServiceImpl constructor
     * @param roleRepository the role repository
     */
    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Handle the get all roles query
     * @param query the get all roles query
     * @return List<Role> the list of roles
     */
    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    /**
     * Handle the get role by name query
     * @param query the get role by name query
     * @return Optional<Role> the role
     */
    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.name());
    }
}
