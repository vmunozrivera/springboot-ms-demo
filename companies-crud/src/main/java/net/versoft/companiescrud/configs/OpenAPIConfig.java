package net.versoft.companiescrud.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
	info = @Info(
		title = "Companies CRUD",
		version="1.0.0",
		description = "This is a CRUD for management companies"
	)	
)
public class OpenAPIConfig {

}
