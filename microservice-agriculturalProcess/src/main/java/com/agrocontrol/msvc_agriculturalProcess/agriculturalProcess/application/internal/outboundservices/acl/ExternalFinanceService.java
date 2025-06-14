package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.application.internal.outboundservices.acl;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.FinanceFeignClient;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.request.CreateFinanceResource;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ExternalFinanceService {
    private final FinanceFeignClient financeFeignClient;

    public ExternalFinanceService(FinanceFeignClient financeFeignClient) {
        this.financeFeignClient = financeFeignClient;
    }

    @CircuitBreaker(name = "finance-agricultural-process-cb")
    @TimeLimiter(name = "finance-agricultural-process-tl")
    public CompletableFuture<Void> createFinance(Long agriculturalProcessId, String type, String description, double value) {
        return CompletableFuture.runAsync(() -> {
            var resource = new CreateFinanceResource(agriculturalProcessId, type, description, value);
            financeFeignClient.createFinance(resource);
        });
    }
}
