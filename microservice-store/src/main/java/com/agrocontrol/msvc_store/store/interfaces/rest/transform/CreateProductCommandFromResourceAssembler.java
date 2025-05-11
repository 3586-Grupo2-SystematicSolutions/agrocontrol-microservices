package com.agrocontrol.msvc_store.store.interfaces.rest.transform;

import com.agrocontrol.msvc_store.store.domain.model.commands.CreateProductCommand;
import com.agrocontrol.msvc_store.store.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {

    public static CreateProductCommand toCommandFromResource(CreateProductResource resource) {
        return new CreateProductCommand(resource.userId(), resource.name(), resource.quantityPerUnit(),
                resource.unitPrice(), resource.quantity(), resource.photoUrl());
    }
}
