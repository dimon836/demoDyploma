package com.example.demodyploma.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi apiDocket() {
        return GroupedOpenApi.builder()
                .group("controller")
                .pathsToMatch("/**")
                .build();
    }
}
