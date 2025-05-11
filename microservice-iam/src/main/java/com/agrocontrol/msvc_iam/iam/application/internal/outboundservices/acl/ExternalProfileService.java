package com.agrocontrol.msvc_iam.iam.application.internal.outboundservices.acl;



import com.agrocontrol.msvc_iam.iam.interfaces.communications.ProfileFeignClient;
import com.agrocontrol.msvc_iam.iam.interfaces.communications.request.CreateAgriculturalProducerResource;
import com.agrocontrol.msvc_iam.iam.interfaces.communications.request.CreateDistributorResource;
import com.agrocontrol.msvc_iam.iam.interfaces.rest.resources.SignUpAgriculturalProducerResource;
import com.agrocontrol.msvc_iam.iam.interfaces.rest.resources.SignUpDistributorResource;
import org.springframework.stereotype.Service;

@Service
public class ExternalProfileService {
    private final ProfileFeignClient profileFeignClient;

    public ExternalProfileService(ProfileFeignClient profileFeignClient) {
        this.profileFeignClient = profileFeignClient;
    }

    public Long createAgriculturalProducer( String fullName, String city, String country,
                                           String phone, String dni, Long userId) {
        var resource = new CreateAgriculturalProducerResource(fullName, city, country, phone, dni);
        return profileFeignClient.createAgriculturalProducer(userId, resource);
    }

    public Long createDistributor(String fullName, String city, String country,
                                  String phone, String companyName, String ruc, Long userId) {
        var resource = new CreateDistributorResource(fullName, city, country, phone, companyName, ruc);
        return profileFeignClient.createDistributor(userId, resource);
    }
}

