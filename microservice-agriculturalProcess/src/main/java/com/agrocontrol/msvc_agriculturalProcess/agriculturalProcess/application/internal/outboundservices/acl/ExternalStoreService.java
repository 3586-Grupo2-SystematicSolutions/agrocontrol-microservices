package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.application.internal.outboundservices.acl;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.StoreFeignClient;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.request.ChangeQuantityOfProductResource;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service("externalStoreService")
public class ExternalStoreService {
    private final StoreFeignClient storeFeignClient;

    public ExternalStoreService(StoreFeignClient storeFeignClient) {
        this.storeFeignClient = storeFeignClient;
    }

    @CircuitBreaker(name = "store-agricultural-process-cb")
    @TimeLimiter(name = "store-agricultural-process-tl")
    public CompletableFuture<String> getProductNameById(Long productId) {
        return CompletableFuture.supplyAsync(() -> storeFeignClient.getProductNameById(productId));
    }

    @CircuitBreaker(name = "store-agricultural-process-cb")
    @TimeLimiter(name = "store-agricultural-process-tl")
    public CompletableFuture<Void> changeQuantityOfProduct(Long productId, Integer quantity) {
        return CompletableFuture.runAsync(() -> {
            var resource = new ChangeQuantityOfProductResource("decrease", quantity);
            storeFeignClient.consumeProductQuantity(productId, resource);
        });
    }
}
