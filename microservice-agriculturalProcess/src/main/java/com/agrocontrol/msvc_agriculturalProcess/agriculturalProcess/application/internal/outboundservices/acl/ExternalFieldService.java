package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.application.internal.outboundservices.acl;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.FieldFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service("externalFieldServiceAgriculturalProcess")
public class ExternalFieldService {
    private final FieldFeignClient fieldFeignClient;

    public ExternalFieldService(FieldFeignClient fieldFeignClient) {
        this.fieldFeignClient = fieldFeignClient;
    }

    @CircuitBreaker(name = "field-agricultural-process-cb")
    @TimeLimiter(name = "field-agricultural-process-tl")
    public CompletableFuture<String> getWorkerNameById(Long workerId) {
        return CompletableFuture.supplyAsync(() -> fieldFeignClient.getWorkerFullNameById(workerId));
    }
}
