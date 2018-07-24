package com.prizy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.prizy",
		"com.prizy.controller",
		"com.prizy.view",
		"com.prizy.services"})
@EnableJpaRepositories("com.prizy.repos")
@EntityScan(value = "com.prizy.entity")
public class PrizyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrizyApplication.class, args);
	}
}
