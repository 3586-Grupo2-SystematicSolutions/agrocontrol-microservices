package com.agrocontrol.msvc_finance.finances.interfaces.rest.transform;


import com.agrocontrol.msvc_finance.finances.domain.model.commands.CreateFinanceCommand;
import com.agrocontrol.msvc_finance.finances.interfaces.rest.resources.CreateFinanceResource;

public class CreateFinanceCommandFromResourceAssembler {
    public static CreateFinanceCommand toCommandFromResource(CreateFinanceResource resource) {
        return new CreateFinanceCommand(
                resource.agriculturalProcessId(),
                resource.type(),
                resource.description(),
                resource.value()
        );
    }
}
