package com.project.api.wealth_guard.configuration;

import graphql.analysis.MaxQueryDepthInstrumentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlSecurityConfiguration {

    @Value("${graphql.config.depthLimit}")
    private int depthLimit;

    @Bean
    MaxQueryDepthInstrumentation maxQueryDepthInstrumentation(){
        return new MaxQueryDepthInstrumentation(depthLimit);
    }
}
