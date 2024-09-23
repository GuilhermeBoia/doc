package com.medway.doc.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        description = "Documentação do sistema de regitsro de consultas de alunos do Grupo Medway",
        title = "MEDWAY-DOC"
    ),
    servers = {
        @Server(
            description = "Local",
            url = "http://localhost:8080"
        )
    }
)
public class SwaggerConfig {
    
}
