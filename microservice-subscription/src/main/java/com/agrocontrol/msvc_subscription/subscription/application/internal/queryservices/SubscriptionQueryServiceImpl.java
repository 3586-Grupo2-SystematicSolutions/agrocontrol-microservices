package com.agrocontrol.msvc_subscription.subscription.application.internal.queryservices;

import com.agrocontrol.msvc_subscription.subscription.domain.model.aggregates.Subscription;
import com.agrocontrol.msvc_subscription.subscription.domain.model.queries.GetSubscriptionByIdQuery;
import com.agrocontrol.msvc_subscription.subscription.domain.model.queries.GetSubscriptionByUserIdQuery;
import com.agrocontrol.msvc_subscription.subscription.domain.services.SubscriptionQueryService;
import com.agrocontrol.msvc_subscription.subscription.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionQueryServiceImpl implements SubscriptionQueryService {
    private final SubscriptionRepository paymentRepository;

    public SubscriptionQueryServiceImpl(SubscriptionRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    @Override
    public Optional<Subscription> handle(GetSubscriptionByUserIdQuery query) {
        return this.paymentRepository.findByUserId(query.userId());
    }

    @Override
    public Optional<Subscription> handle(GetSubscriptionByIdQuery query) {
        return this.paymentRepository.findById(query.id());
    }
}
