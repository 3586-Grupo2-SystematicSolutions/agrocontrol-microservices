package com.agrocontrol.msvc_subscription.subscription.domain.services;

import com.agrocontrol.msvc_subscription.subscription.domain.model.aggregates.Subscription;
import com.agrocontrol.msvc_subscription.subscription.domain.model.queries.GetSubscriptionByIdQuery;
import com.agrocontrol.msvc_subscription.subscription.domain.model.queries.GetSubscriptionByUserIdQuery;

import java.util.Optional;

public interface SubscriptionQueryService {
    Optional<Subscription> handle(GetSubscriptionByUserIdQuery query);
    Optional<Subscription> handle(GetSubscriptionByIdQuery query);
}
