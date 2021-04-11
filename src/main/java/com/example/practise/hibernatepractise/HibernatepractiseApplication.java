package com.example.practise.hibernatepractise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource("classpath:HibernatePractise-application.properties")
@EnableJpaRepositories(basePackages = "com.example.practise.hibernatepractise.*")
public class HibernatepractiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatepractiseApplication.class, args);
	}

}
