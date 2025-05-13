package com.agrocontrol.msvc_store.store.application.internal.outboundservices.acl;


import com.agrocontrol.msvc_store.store.interfaces.communications.ProfileFeignClient;
import org.springframework.stereotype.Service;

@Service("externalProfileServiceStore")
public class ExternalProfileService {

    private final ProfileFeignClient profileFeignClient;

    public ExternalProfileService(ProfileFeignClient profileFeignClient) {
        this.profileFeignClient = profileFeignClient;
    }

    public void existsDistributor(Long userId) {
        boolean exists = profileFeignClient.existsDistributorByUserId(userId);
        if (!exists) {
            throw new IllegalArgumentException("Distributor not found with id %s".formatted(userId));
        }
    }

    public void existsAgriculturalProducer(Long userId) {
        boolean exists = profileFeignClient.existsAgriculturalProducerByUserId(userId);
        if (!exists) {
            throw new IllegalArgumentException("Agricultural Prodcuer not found with id %s".formatted(userId));
        }
    }
}
