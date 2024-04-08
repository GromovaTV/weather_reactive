package ru.job4j.weather.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(title = "Weather Service API"),
        servers = @Server(url = "https://weather.195-2-71-38.traefik.me")
)
public class SwaggerConfig {

    @Bean
    public OpenAPI weatherOpenApi() {
        String schemaName = "Auth JWT";
        return new OpenAPI().addSecurityItem(new SecurityRequirement().addList(schemaName))
                .components(new Components().addSecuritySchemes(schemaName,
                        new SecurityScheme()
                                .name(schemaName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))
                );
    }
}
