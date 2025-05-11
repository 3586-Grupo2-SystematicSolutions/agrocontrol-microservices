package com.agrocontrol.msvc_subscription.subscription.domain.services;

import com.agrocontrol.msvc_subscription.subscription.domain.model.aggregates.Subscription;
import com.agrocontrol.msvc_subscription.subscription.domain.model.commands.CreateSubscriptionCommand;
import com.agrocontrol.msvc_subscription.subscription.domain.model.commands.RenewSubscriptionCommand;
import com.agrocontrol.msvc_subscription.subscription.domain.model.commands.UpdatePlanTypeCommand;

import java.util.Optional;

public interface SubscriptionCommandService {
    Optional<Subscription> handle(CreateSubscriptionCommand command);
    Optional<Subscription> handle(RenewSubscriptionCommand command);
    Optional<Subscription> handle(UpdatePlanTypeCommand command);
}
