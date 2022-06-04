package com.example.demodyploma.controller;

import com.example.demodyploma.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private Long id;
    private String login;
    private String token;
    private RoleEntity role;
}
