package com.loja.roupas.trein.infra.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("WenShop API ")
                        .version("v1")
                        .description("REST API do WenShop - Loja de roupas online")
                        .license(new License() //não precisa
                                .name("Apache 2.0")
                                .url("http://springdoc.com")
                        )
                ).externalDocs(new ExternalDocumentation()
                        .description("Mais informações : Github Wenega")
                        .url("https://github.com/wenegawama/loja-roupas")
                ).tags(Arrays.asList(
                        new Tag().name("Vendedor").description("Gerencia as ações do vendedor"),
                        new Tag().name("Usuario").description("Gerência as ações do usuário")
                ))
                ;
    }
    /*
    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("WenShop API")
                .pathsToMatch("/api/v1/users/**")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("WenShop API")
                            .version("v1")
                            .description("REST API do WenShop - Loja de Roupas online")
                            .license(new License() //não precisa
                                    .name("Apache 2.0")
                                    .url("http://springdoc.com")
                            )
                    ).externalDocs(new ExternalDocumentation()
                            .description("Mais informações : Github Wenega")
                            .url("https://github.com/wenegawama/loja-roupas")
                    );
                })
                .build();
    }
    @Bean
    public GroupedOpenApi groupedOpenApiVendedor() {
        return GroupedOpenApi.builder()
                .group("WenShop API do vendedor")
                .pathsToMatch("/api/v1/users/sellers/**")
                .addOpenApiCustomizer(openApi -> {
                    openApi.info(new Info()
                            .title("WenShop API do vendedor")
                            .version("v1")
                            .description("REST API do WenShop - Loja de Roupas online")
                            .license(new License() //não precisa
                                    .name("Apache 2.0")
                                    .url("http://springdoc.com")
                            )
                    ).externalDocs(new ExternalDocumentation()
                            .description("Mais informações : Github Wenega")
                            .url("https://github.com/wenegawama/loja-roupas")
                    );
                })
                .build();
    }

     */
}
