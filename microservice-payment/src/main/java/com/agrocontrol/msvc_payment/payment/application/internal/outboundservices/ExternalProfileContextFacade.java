package com.agrocontrol.msvc_payment.payment.application.internal.outboundservices;

import com.agrocontrol.msvc_payment.payment.interfaces.communications.ProfileFeignClient;
import org.springframework.stereotype.Service;

@Service("externalProfileServicePaymentProduct")
public class ExternalProfileContextFacade {
    private final ProfileFeignClient profileFeignClient;

    public ExternalProfileContextFacade(ProfileFeignClient profileFeignClient) {
        this.profileFeignClient = profileFeignClient;
    }

    public void exitsAgriculturalProducer(Long userId) {
        boolean exists = profileFeignClient.existsAgriculturalProducerByUserId(userId);
        if (!exists) {
            throw new IllegalArgumentException("Agricultural Producer not found with id %s".formatted(userId));
        }
    }
}
