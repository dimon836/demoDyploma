package com.example.demodyploma.controller;

import com.example.demodyploma.entity.UserEntity;
import com.example.demodyploma.service.UserService;
import com.example.demodyploma.util.OnlineCompilerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CompilerController {

    private final UserService userService;

    @Autowired
    public CompilerController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/compile")
    public String compile(@RequestBody CompilerRequest compilerRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();

        UserEntity userEntity = userService.findByLogin(login);

        return OnlineCompilerUtil.compileCode(userEntity, compilerRequest.getCode());
    }
}
