package com.agrocontrol.msvc_store.store.interfaces.rest.transform;

import com.agrocontrol.msvc_store.store.domain.model.commands.CreatePaymentProductCommand;
import com.agrocontrol.msvc_store.store.interfaces.rest.resources.CreatePaymentProductResource;

public class CreatePaymentProductCommandFromResourceAssembler {
    public static CreatePaymentProductCommand toCommandFromResource(CreatePaymentProductResource command) {
        return new CreatePaymentProductCommand( command.productId(), command.quantityProduct(),
                command.userId());
    }
}
