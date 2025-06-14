package com.agrocontrol.msvc_payment.payment.application.internal.outboundservices;

import com.agrocontrol.msvc_payment.payment.interfaces.communications.ProfileFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service("externalProfileServicePaymentProduct")
public class ExternalProfileContextFacade {
    private final ProfileFeignClient profileFeignClient;

    public ExternalProfileContextFacade(ProfileFeignClient profileFeignClient) {
        this.profileFeignClient = profileFeignClient;
    }

    @CircuitBreaker(name = "profile-payment-cb")
    @TimeLimiter(name = "profile-payment-tl")
    public CompletableFuture<Void> existsAgriculturalProducer(Long userId) {
        return CompletableFuture.runAsync(() -> {
            boolean exists = profileFeignClient.existsAgriculturalProducerByUserId(userId);
            if (!exists) {
                throw new IllegalArgumentException("Agricultural Producer not found with id %s".formatted(userId));
            }
        });
    }
}
