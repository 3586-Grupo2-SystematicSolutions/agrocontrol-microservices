package com.agrocontrol.msvc_profile.profiles.domain.model.commands;

public record CreateAgriculturalProducerCommand(String fullName, String city, String country,
                                                String phone, String dni) {
}
