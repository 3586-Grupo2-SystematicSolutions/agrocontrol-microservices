package com.agrocontrol.msvc_store.store.interfaces.communications;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-profile", url = "localhost:8080/api/v1/profiles")
public interface ProfileFeignClient {
    @GetMapping("/distributor/exists/{userId}")
    Boolean existsDistributorByUserId(@PathVariable Long userId);
}
