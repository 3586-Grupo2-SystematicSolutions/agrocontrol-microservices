package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.application.internal.outboundservices.acl;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.interfaces.communications.FieldFeignClient;
import org.springframework.stereotype.Service;

@Service
public class ExternalWorkerService {
    private final FieldFeignClient fieldFeignClient;

    public ExternalWorkerService(FieldFeignClient fieldFeignClient) {
        this.fieldFeignClient = fieldFeignClient;
    }

    public String getWorkerNameById(Long workerId) {
        return fieldFeignClient.getWorkerFullNameById(workerId);
    }
}
