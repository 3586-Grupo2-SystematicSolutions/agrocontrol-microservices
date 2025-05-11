package com.agrocontrol.msvc_finance.finances.domain.services;

import com.agrocontrol.msvc_finance.finances.domain.model.aggregates.Finance;
import com.agrocontrol.msvc_finance.finances.domain.model.commands.CreateFinanceCommand;

import java.util.Optional;

public interface FinanceCommandService {
    Optional<Finance> handle(CreateFinanceCommand command);
}
