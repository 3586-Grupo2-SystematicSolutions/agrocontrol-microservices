package com.agrocontrol.msvc_store.store.application.internal.outboundservices.acl;


import com.agrocontrol.msvc_store.store.interfaces.communications.ProfileFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service("externalProfileServiceStore")
public class ExternalProfileService {

    private final ProfileFeignClient profileFeignClient;

    public ExternalProfileService(ProfileFeignClient profileFeignClient) {
        this.profileFeignClient = profileFeignClient;
    }

    @CircuitBreaker(name = "profile-store-cb")
    @TimeLimiter(name = "profile-store-tl")
    public CompletableFuture<Void> existsDistributor(Long userId) {
        return CompletableFuture.runAsync(() -> {
            boolean exists = profileFeignClient.existsDistributorByUserId(userId);
            if (!exists) {
                throw new IllegalArgumentException("Distributor not found with id %s".formatted(userId));
            }
        });
    }

    @CircuitBreaker(name = "profile-store-cb")
    @TimeLimiter(name = "profile-store-tl")
    public CompletableFuture<Void> existsAgriculturalProducer(Long userId) {
        return CompletableFuture.runAsync(() -> {
            boolean exists = profileFeignClient.existsAgriculturalProducerByUserId(userId);
            if (!exists) {
                throw new IllegalArgumentException("Agricultural Producer not found with id %s".formatted(userId));
            }
        });
    }
}
