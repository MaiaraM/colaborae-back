package com.galaxyware.colaborae;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ColaboraeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColaboraeApplication.class, args);
	}

}
