package ru.starcompany.printer.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Printer Api",
                description = "Printer", version = "0.0.3",
                contact = @Contact(
                        url = "https://github.com/sallich"
                )
        )
)
public class SwaggerConfig {

}
