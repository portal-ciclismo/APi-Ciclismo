package br.com.dcx.ufpb.eng.ApiCiclismo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.dcx.ufpb.eng.ApiCiclismo"})
public class ApiCiclismoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCiclismoApplication.class, args);
	}

}
