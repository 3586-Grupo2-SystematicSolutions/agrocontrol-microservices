package com.agrocontrol.msvc_store.store.domain.services;

import com.agrocontrol.msvc_store.store.domain.model.aggregates.PaymentProduct;
import com.agrocontrol.msvc_store.store.domain.model.queries.GetPaymentProductByOwnerProductId;
import com.agrocontrol.msvc_store.store.domain.model.queries.GetPaymentProductByUserIdQuery;

import java.util.List;

public interface PaymentProductQueryService {
    List<PaymentProduct> handle(GetPaymentProductByOwnerProductId query);
    List<PaymentProduct> handle(GetPaymentProductByUserIdQuery query);
}
