package com.api.envio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "com.api.envio")
public class EnvioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvioApplication.class, args);
	}

}
