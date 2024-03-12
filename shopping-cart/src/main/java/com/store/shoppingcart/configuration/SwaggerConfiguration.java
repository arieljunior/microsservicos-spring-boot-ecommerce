package com.store.shoppingcart.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info=@Info(title="Título", description = "Microsserviço de carrinho de compras", version = "v1", license = @License(name="MIT", url="http:localhost")))
public class SwaggerConfiguration {
}
