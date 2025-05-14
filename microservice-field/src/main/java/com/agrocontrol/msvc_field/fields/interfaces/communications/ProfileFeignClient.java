package com.agrocontrol.msvc_field.fields.interfaces.communications;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-profile")
public interface ProfileFeignClient {
    @GetMapping("/api/v1/profiles/agricultural-producer/exists/{userId}")
    Boolean existsAgriculturalProducerByUserId(@PathVariable Long userId);
}
