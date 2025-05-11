package com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.entities;

import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.aggregates.AgriculturalProcess;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.valueobjects.ActivityType;
import com.agrocontrol.msvc_agriculturalProcess.agriculturalProcess.domain.model.valueobjects.AgriculturalActivity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@DiscriminatorValue("HARVEST")
public class Harvest extends AgriculturalActivity {

    @Getter
    private double quantityInKg;

    @Getter
    private double pricePerKg;

    @Getter
    private double totalIncome;

    protected Harvest() {}

    public Harvest(AgriculturalProcess agriculturalProcess, ActivityType activityType, String date, double quantityInKg, double pricePerKg) {
        super(agriculturalProcess, activityType, date);
        this.quantityInKg = quantityInKg;
        this.pricePerKg = pricePerKg;
        this.totalIncome = quantityInKg * pricePerKg;
    }
}
