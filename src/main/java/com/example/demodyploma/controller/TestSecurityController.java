package com.example.demodyploma.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {

    @GetMapping("/role_user/get")
    public String getUserRole() {
        return "Hi User!";
    }

    @GetMapping("/role_admin/get")
    public String getAdminRole() {
        return "Hi admin!";
    }
}
