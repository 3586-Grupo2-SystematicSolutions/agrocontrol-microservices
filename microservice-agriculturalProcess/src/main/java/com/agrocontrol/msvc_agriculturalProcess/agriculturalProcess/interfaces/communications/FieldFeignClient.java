package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-field", url = "localhost:8080/api/v1/workers")
public interface FieldFeignClient {
    @GetMapping("/fullName/{workerId}")
    String getWorkerFullNameById(@PathVariable Long workerId);
}
