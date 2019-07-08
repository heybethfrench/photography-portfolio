package com.bethfrench.photographyportfolio;

import com.bethfrench.photographyportfolio.storage.StorageProperties;
import com.bethfrench.photographyportfolio.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/*@EnableAutoConfiguration(StorageProperties.class)*/
public class PhotographyPortfolioApplication {

	public static void main(String[] args) {

		SpringApplication.run(PhotographyPortfolioApplication.class, args);
	}

/*
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
*/
	}


