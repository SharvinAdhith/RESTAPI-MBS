package com.example.mbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("BoatHouse Management API")
                        .description("API documentation for managing BoatHouse, Bookings, Owners, and Users")
                        .version("1.0"));
    }
}
