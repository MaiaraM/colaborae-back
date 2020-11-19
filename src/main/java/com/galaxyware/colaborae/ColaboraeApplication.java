package com.galaxyware.colaborae;

import com.galaxyware.colaborae.config.JWTAuthenticationFilter;
import com.galaxyware.colaborae.config.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@SpringBootApplication
@EnableJpaAuditing
public class ColaboraeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColaboraeApplication.class, args);
	}

	@Bean
	protected JWTAuthenticationFilter jwtAuthenticationFilter(@Autowired TokenAuthenticationService tokenAuthenticationService ) {
		JWTAuthenticationFilter authFilter = new JWTAuthenticationFilter(tokenAuthenticationService);
		return authFilter;
	}


}

