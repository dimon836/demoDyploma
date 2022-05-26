package com.example.demodyploma.config;

import com.example.demodyploma.service.UserService;
import com.example.demodyploma.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ImplementationOfUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public ImplementationOfUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByLogin(username);
        return ImplementationOfUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
