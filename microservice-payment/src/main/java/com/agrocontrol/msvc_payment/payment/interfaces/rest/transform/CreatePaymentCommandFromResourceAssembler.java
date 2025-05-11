package com.agrocontrol.msvc_payment.payment.interfaces.rest.transform;

import com.agrocontrol.msvc_payment.payment.domain.model.commands.CreatePaymentCommand;
import com.agrocontrol.msvc_payment.payment.interfaces.rest.resources.CreatePaymentResource;

public class CreatePaymentCommandFromResourceAssembler {
    public static CreatePaymentCommand toCommandFromSource(CreatePaymentResource resource) {
        return new CreatePaymentCommand(
                resource.subscriptionId(),
                resource.date(),
                resource.state(),
                resource.cardHolderName(),
                resource.cardNumber(),
                resource.ExpireDate(),
                resource.cvv()
        );
    }
}
