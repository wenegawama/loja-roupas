package com.loja.roupas.trein.infra.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Loja de roupas", version="1", description="API desenvolvida para treinamento ESTAG"),
        servers = {@Server(url= "http://localhost:8080", description = "Local server")}
)
public class SwaggerConfig {
}
