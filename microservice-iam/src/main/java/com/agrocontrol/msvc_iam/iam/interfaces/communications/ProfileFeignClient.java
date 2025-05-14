package com.agrocontrol.msvc_iam.iam.interfaces.communications;

import com.agrocontrol.msvc_iam.iam.interfaces.communications.request.CreateAgriculturalProducerResource;
import com.agrocontrol.msvc_iam.iam.interfaces.communications.request.CreateDistributorResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-profile")
public interface ProfileFeignClient {
    @PostMapping("/api/v1/profiles/agricultural-producer/{userId}")
    Long createAgriculturalProducer(@PathVariable Long userId, @RequestBody CreateAgriculturalProducerResource resource);

    @PostMapping("/api/v1/profiles/distributor/{userId}")
    Long createDistributor(@PathVariable Long userId, @RequestBody CreateDistributorResource resource);
}
