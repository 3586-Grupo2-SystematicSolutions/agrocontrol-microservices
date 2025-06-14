package com.agrocontrol.msvc_field.fields.application.internal.outboundservices.acl;

import com.agrocontrol.msvc_field.fields.interfaces.communications.ProfileFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service("externalProfileServiceFields")
public class ExternalProfileService {

    private final ProfileFeignClient profileFeignClient;

    public ExternalProfileService(ProfileFeignClient profileFeignClient) {
        this.profileFeignClient = profileFeignClient;
    }

    @CircuitBreaker(name = "profile-field-cb")
    @TimeLimiter(name = "profile-field-tl")
    public CompletableFuture<Void> existsAgriculturalProducer(Long userId) {
        return CompletableFuture.runAsync(() -> {
            boolean exists = profileFeignClient.existsAgriculturalProducerByUserId(userId);
            if (!exists) {
                throw new IllegalArgumentException("Agricultural Producer not found with id %s".formatted(userId));
            }
        });
    }
}
