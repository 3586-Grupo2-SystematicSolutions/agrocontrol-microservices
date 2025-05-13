package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.application.internal.outboundservices.acl;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.FinanceFeignClient;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.request.CreateFinanceResource;
import org.springframework.stereotype.Service;

@Service
public class ExternalFinanceService {
    private final FinanceFeignClient financeFeignClient;

    public ExternalFinanceService(FinanceFeignClient financeFeignClient) {
        this.financeFeignClient = financeFeignClient;
    }

    public void createFinance(Long agriculturalProcessId, String type, String description, double value) {
        var resource = new CreateFinanceResource(agriculturalProcessId, type, description, value);
        this.financeFeignClient.createFinance(resource);
    }
}
