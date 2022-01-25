package com.inspire12.practice.lab.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.logging.log4j2.SpringBootPropertySource;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringProperties;

import java.util.Properties;

@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    private final ConfigurableApplicationContext applicationContext;

    @Bean
    public OpenAPI customOpenAPI(@Value("${pom.version}") String version,
                                 @Value("${pom.description}") String description) {

        return new OpenAPI().info(new Info()
                .title(applicationContext.getApplicationName())
                .version(version)
                .description(description)
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0")
                .url("http://springdoc.org")));
    }
}
