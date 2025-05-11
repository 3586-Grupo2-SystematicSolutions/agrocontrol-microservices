package com.agrocontrol.msvc_subscription.subscription.infrastructure.persistence.jpa.repositories;

import com.agrocontrol.msvc_subscription.subscription.domain.model.aggregates.Subscription;
import com.agrocontrol.msvc_subscription.subscription.domain.model.valueobjects.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByUserId(UserId userId);
}
