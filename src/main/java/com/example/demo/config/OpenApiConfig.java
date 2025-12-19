

@Value("${app.swagger.server-url:}")
private String serverUrl;

@Bean
public OpenAPI customOpenAPI() {
    OpenAPI openAPI = new OpenAPI()
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(
                    new Components().addSecuritySchemes(
                            "bearerAuth",
                            new SecurityScheme()
                                    .type(SecurityScheme.Type.HTTP)
                                    .scheme("bearer")
                                    .bearerFormat("JWT")
                    )
            );

    if (!serverUrl.isBlank()) {
        openAPI.setServers(List.of(new Server().url(serverUrl)));
    }

    return openAPI;
}
