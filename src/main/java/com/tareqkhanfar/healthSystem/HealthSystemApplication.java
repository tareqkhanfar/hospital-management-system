package com.tareqkhanfar.healthSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.tareqkhanfar.healthSystem.Model.Entity")

public class HealthSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthSystemApplication.class, args);
	}

}
