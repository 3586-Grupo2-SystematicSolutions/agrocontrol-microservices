package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.application.internal.outboundservices.acl;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.ProductFeignClient;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.request.ChangeQuantityOfProductResource;
import org.springframework.stereotype.Service;

@Service("externalStoreService")
public class ExternalStoreService {
    private final ProductFeignClient productFeignClient;

    public ExternalStoreService(ProductFeignClient productFeignClient) {
        this.productFeignClient = productFeignClient;
    }

    public String getProductNameById(Long productId) {
        return this.productFeignClient.getProductNameById(productId);
    }

    public void changeQuantityOfProduct(Long productId, Integer quantity) {
        var resource = new ChangeQuantityOfProductResource( "decrease", quantity);
        this.productFeignClient.consumeProductQuantity(productId, resource);
    }
}
