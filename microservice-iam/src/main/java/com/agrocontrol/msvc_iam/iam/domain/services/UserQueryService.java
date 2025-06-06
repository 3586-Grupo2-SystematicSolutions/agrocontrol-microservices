package com.agrocontrol.msvc_iam.iam.domain.services;

import com.agrocontrol.msvc_iam.iam.domain.model.aggregates.User;
import com.agrocontrol.msvc_iam.iam.domain.model.queries.CheckUserByIdQuery;
import com.agrocontrol.msvc_iam.iam.domain.model.queries.GetAllUsersQuery;
import com.agrocontrol.msvc_iam.iam.domain.model.queries.GetUserByIdQuery;
import com.agrocontrol.msvc_iam.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);
    boolean handle(CheckUserByIdQuery query);
}
