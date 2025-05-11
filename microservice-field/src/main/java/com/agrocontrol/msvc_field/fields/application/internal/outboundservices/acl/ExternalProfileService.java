package com.agrocontrol.msvc_field.fields.application.internal.outboundservices.acl;

import com.agrocontrol.msvc_field.fields.interfaces.communications.ProfileFeignClient;
import org.springframework.stereotype.Service;

@Service("externalProfileServiceFields")
public class ExternalProfileService {

    private final ProfileFeignClient profileFeignClient;

    public ExternalProfileService(ProfileFeignClient profileFeignClient) {
        this.profileFeignClient = profileFeignClient;
    }

    public void exitsAgriculturalProducer(Long userId) {
        boolean exists = profileFeignClient.existsAgriculturalProducerByUserId(userId);
        if (!exists) {
            throw new IllegalArgumentException("Agricultural Producer not found with id %s".formatted(userId));
        }
    }
}
