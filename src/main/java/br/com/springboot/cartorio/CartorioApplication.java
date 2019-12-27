package br.com.springboot.cartorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"br.com.springboot.cartorio"})
@EnableJpaRepositories(basePackages="br.com.springboot.cartorio.repository")
public class CartorioApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CartorioApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CartorioApplication.class);
	}
}
