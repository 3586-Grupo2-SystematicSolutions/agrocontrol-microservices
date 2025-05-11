package com.agrocontrol.msvc_finance.finances.domain.services;

import com.agrocontrol.msvc_finance.finances.domain.model.aggregates.Finance;
import com.agrocontrol.msvc_finance.finances.domain.model.queries.GetFinancesByAgriculturalProcessIdQuery;

import java.util.List;

public interface FinanceQueryService {
    List<Finance> handle(GetFinancesByAgriculturalProcessIdQuery query);
}
