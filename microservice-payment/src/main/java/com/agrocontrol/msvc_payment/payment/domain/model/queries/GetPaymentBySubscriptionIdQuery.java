package com.agrocontrol.msvc_payment.payment.domain.model.queries;

import com.agrocontrol.msvc_payment.payment.domain.model.valueobjects.SubscriptionId;

public record GetPaymentBySubscriptionIdQuery(SubscriptionId subscriptionId) {

}
