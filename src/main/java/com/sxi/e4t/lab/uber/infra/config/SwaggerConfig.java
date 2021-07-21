package com.sxi.e4t.lab.uber.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Uber Service REST API.")
                        .description(""" 
                                A Spring boot based REST API application to demonstrate,
                                the correct implementations of handling <italic>(saving, searching, and retrieving)</italic>
                                <strong>Zoned datetime</strong>.""")
                        .version("1.0")
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));

    }

}
