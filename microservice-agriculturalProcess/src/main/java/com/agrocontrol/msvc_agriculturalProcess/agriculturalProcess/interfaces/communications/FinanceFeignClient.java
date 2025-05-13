package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.request.CreateFinanceResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-finance", url = "localhost:8080/api/v1/finances")
public interface FinanceFeignClient {
    @PostMapping("/external-finance")
    void createFinance(@RequestBody CreateFinanceResource resource);
}
