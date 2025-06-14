package com.agrocontrol.msvc_iam.iam.application.internal.outboundservices.acl;

import com.agrocontrol.msvc_iam.iam.interfaces.communications.ProfileFeignClient;
import com.agrocontrol.msvc_iam.iam.interfaces.communications.request.CreateAgriculturalProducerResource;
import com.agrocontrol.msvc_iam.iam.interfaces.communications.request.CreateDistributorResource;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class ExternalProfileService {

    private final ProfileFeignClient profileFeignClient;

    public ExternalProfileService(ProfileFeignClient profileFeignClient) {
        this.profileFeignClient = profileFeignClient;
    }

    @CircuitBreaker(name = "profile-cb", fallbackMethod = "fallbackAgriculturalProducer")
    @TimeLimiter(name = "profile-tl")
    public CompletableFuture<Long> createAgriculturalProducer(String fullName, String city, String country,
                                                              String phone, String dni, Long userId) {
        return CompletableFuture.supplyAsync(() -> {
            var resource = new CreateAgriculturalProducerResource(fullName, city, country, phone, dni);
            return profileFeignClient.createAgriculturalProducer(userId, resource);
        });
    }

    @CircuitBreaker(name = "profile-cb", fallbackMethod = "fallbackDistributor")
    @TimeLimiter(name = "profile-tl")
    public CompletableFuture<Long> createDistributor(String fullName, String city, String country,
                                                     String phone, String companyName, String ruc, Long userId) {
        return CompletableFuture.supplyAsync(() -> {
            var resource = new CreateDistributorResource(fullName, city, country, phone, companyName, ruc);
            return profileFeignClient.createDistributor(userId, resource);
        });
    }

    // Fallback para createAgriculturalProducer
    public CompletableFuture<Long> fallbackAgriculturalProducer(String fullName, String city, String country,
                                                                String phone, String dni, Long userId, Throwable throwable) {
        return CompletableFuture.failedFuture(
                new RuntimeException("Too many failed attempts. Please try again in 7 seconds.")
        );
    }

    // Fallback para createDistributor
    public CompletableFuture<Long> fallbackDistributor(String fullName, String city, String country,
                                                       String phone, String companyName, String ruc, Long userId, Throwable throwable) {
        return CompletableFuture.failedFuture(
                new RuntimeException("Too many failed attempts. Please try again in 7 seconds.")
        );
    }
}
