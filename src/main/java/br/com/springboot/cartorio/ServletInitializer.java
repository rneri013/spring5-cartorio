package br.com.springboot.cartorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CartorioApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CartorioApplication.class, args);
	}
	
}