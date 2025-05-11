package com.agrocontrol.msvc_store.store.interfaces.rest.transform;

import com.agrocontrol.msvc_store.store.domain.model.aggregates.PaymentProduct;
import com.agrocontrol.msvc_store.store.interfaces.rest.resources.PaymentProductResource;

public class PaymentProductResourceFromEntityAssembler {
    public static PaymentProductResource toResourceFromEntity(PaymentProduct paymentProduct) {
        return new PaymentProductResource(paymentProduct.getId(),paymentProduct.getDate(),
                paymentProduct.getProductId(), paymentProduct.getProductName(), paymentProduct.getQuantityProduct(), paymentProduct.getTotalCost(),
                paymentProduct.getUserId(), paymentProduct.getOwnerProductId());
    }
}
