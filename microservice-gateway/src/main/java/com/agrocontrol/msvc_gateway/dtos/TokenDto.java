package com.agrocontrol.msvc_gateway.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenDto {
    private Long id;
    private String username;
    private List<String> roles;
    private String token;
}
