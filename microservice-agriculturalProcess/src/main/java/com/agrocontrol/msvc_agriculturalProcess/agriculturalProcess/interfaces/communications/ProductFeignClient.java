package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.request.ChangeQuantityOfProductResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-product", url = "localhost:8080/api/v1/products")
public interface ProductFeignClient {
    @GetMapping("/name/{productId}")
    String getProductNameById (@PathVariable Long productId);

    @PutMapping("/consume-quantity/{productId}")
    Void consumeProductQuantity(@PathVariable Long productId, @RequestBody ChangeQuantityOfProductResource resource);
}
