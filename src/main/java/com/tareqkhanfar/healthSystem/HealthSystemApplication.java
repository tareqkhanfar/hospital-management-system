package com.tareqkhanfar.healthSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan("com.tareqkhanfar.healthSystem.Model.Entity")
@EnableWebMvc
public class HealthSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthSystemApplication.class, args);
	}

}
