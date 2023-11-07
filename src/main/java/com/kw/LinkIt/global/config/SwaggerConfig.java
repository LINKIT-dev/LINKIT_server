package com.kw.LinkIt.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "LINKIT API Documentation",
                description = "LINKIT API 명세 페이지입니다.",
                version = "v1"
        )
)
@Configuration
public class SwaggerConfig {
}
