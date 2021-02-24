package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication(scanBasePackages={"com.ecommerce.controller", "com.ecommerce.entity","com.ecommerce.model",
"com.ecommerce.repository","com.ecommerce.service","com.prueba"})
public class PruebaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}
}
