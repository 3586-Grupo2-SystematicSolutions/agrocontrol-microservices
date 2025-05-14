package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-field")
public interface FieldFeignClient {
    @GetMapping("/api/v1/workers/fullName/{workerId}")
    String getWorkerFullNameById(@PathVariable Long workerId);
}
