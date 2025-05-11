package com.agrocontrol.msvc_store.store.interfaces.rest.transform;

import com.agrocontrol.msvc_store.store.domain.model.commands.ChangeQuantityOfProductCommand;
import com.agrocontrol.msvc_store.store.interfaces.rest.resources.ChangeQuantityOfProductResource;

public class ChangeQuantityOfProductCommandFromResourceAssembler {
    public static ChangeQuantityOfProductCommand toCommandFromResource(ChangeQuantityOfProductResource resource, Long id) {
        return new ChangeQuantityOfProductCommand(
                resource.action().toLowerCase(),
                resource.quantity(),
                id
        );
    }
}
