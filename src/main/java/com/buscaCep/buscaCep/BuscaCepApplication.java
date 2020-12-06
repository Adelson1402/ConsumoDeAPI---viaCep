package com.buscaCep.buscaCep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({("com.buscaCep.buscaCep.consume"),("com.buscaCep.buscaCep.service"), ("repository")})
@EntityScan("com.buscaCep.buscaCep.model")

public class BuscaCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuscaCepApplication.class, args);
	}

}
