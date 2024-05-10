package com.demo.holidaycalendar.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "Holiday API",
                                description = "Holiday Calendar for USA/Canada",
                                summary = "This application will retrieve,add and update holiday calendar",
                                version = "v1"),
servers = @Server(description = "dev", url = "http://localhost:8080"))

public class OpenConfig {
}
