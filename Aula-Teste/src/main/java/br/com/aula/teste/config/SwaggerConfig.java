package br.com.aula.teste.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Value("${prop.swagger.dev-url}")
	private String devUrl;

	@Bean
	OpenAPI myOpenAPI() {
		Server server = new Server();
		
		server.setUrl(devUrl);
		server.setDescription("Server URL - ambiente de desenvolvimento");

		Contact contact = new Contact();
		contact.setEmail("deboramat.ipac@gmail.com");
		contact.setName("Débora de Oliveira Souza");
		contact.setUrl("http://www.aula-teste.com.br");

		Info info = new Info().title("Documentação API - Aula Teste SENAC Petrópolis").version("1.0.0").contact(contact)
				.description("API com endpoints da Aula Teste.")
				.termsOfService("http://www.aula-teste.com.br/terms");

		return new OpenAPI().info(info).servers(List.of(server));
	}
}


