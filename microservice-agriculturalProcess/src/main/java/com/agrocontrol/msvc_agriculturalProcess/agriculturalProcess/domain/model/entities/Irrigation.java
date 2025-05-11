package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.entities;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.aggregates.AgriculturalProcess;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.valueobjects.ActivityType;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.valueobjects.AgriculturalActivity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("IRRIGATION")
public class Irrigation extends AgriculturalActivity {

    @Getter
    private Integer hoursIrrigated;

    protected Irrigation() {}

    public Irrigation(AgriculturalProcess agriculturalProcess, ActivityType activityType, String date, Integer hoursIrrigated) {
        super(agriculturalProcess, activityType, date);
        this.hoursIrrigated = hoursIrrigated;
    }
}
