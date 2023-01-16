package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan ;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories 
;
import org.springframework.boot.autoconfigure.domain.EntityScan ;
@EnableEurekaClient
@SpringBootApplication
@ComponentScan( {"com.example.demo.*"})
@EnableJpaRepositories( {"com.example.demo.repository"})
@EntityScan("com.example.demo.entity")
public class LoginKeycloakApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginKeycloakApplication.class, args);
	}

}
