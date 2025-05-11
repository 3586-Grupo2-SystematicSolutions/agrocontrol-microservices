package com.agrocontrol.msvc_subscription.subscription.domain.model.queries;

import com.agrocontrol.msvc_subscription.subscription.domain.model.valueobjects.UserId;

public record GetSubscriptionByUserIdQuery(
        UserId userId
) {
}
