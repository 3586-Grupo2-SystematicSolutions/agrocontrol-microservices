package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.queries;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.valueobjects.ActivityType;

public record GetActivitiesByActivityTypeAndAgriculturalProcessIdQuery(
        ActivityType activityType,
        Long agriculturalProcessId
) {
}
