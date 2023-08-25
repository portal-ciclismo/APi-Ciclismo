package br.com.dcx.ufpb.eng.ApiCiclismo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
@Info(title = "API Ciclismo",version = "v1",description = "Api Desenvolvida projeto engenharia de software aplicada")
)
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPi(){
        return new OpenAPI().components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info().title("Book Service").version("V1").description("Create por Vinicius Dias")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
