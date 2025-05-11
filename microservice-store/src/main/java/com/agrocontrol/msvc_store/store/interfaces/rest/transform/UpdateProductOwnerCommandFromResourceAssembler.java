package com.agrocontrol.msvc_store.store.interfaces.rest.transform;

import com.agrocontrol.msvc_store.store.domain.model.commands.UpdateProductOwnerCommand;
import com.agrocontrol.msvc_store.store.interfaces.rest.resources.UpdateProductOwnerResource;

public class UpdateProductOwnerCommandFromResourceAssembler {

    public static UpdateProductOwnerCommand toCommandFromResource(UpdateProductOwnerResource resource) {
        return new UpdateProductOwnerCommand(resource.userId(), resource.productId());
    }
}
