package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-product", url = "localhost:8080/api/v1/products")
public interface ProductFeignClient {
    @GetMapping("/name/{productId}")
    String getProductNameById (@PathVariable("productId") String productId);
}
