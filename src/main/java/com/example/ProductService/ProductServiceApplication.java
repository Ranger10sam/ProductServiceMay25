package com.example.ProductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);

		// Add this to your main method or a @PostConstruct method
		String trustStorePath = System.getProperty("javax.net.ssl.trustStore");
		String trustStorePassword = System.getProperty("javax.net.ssl.trustStorePassword");

		System.out.println("--- SSL/TLS Configuration Check ---");
		System.out.println("Trust Store Path: " + (trustStorePath != null ? trustStorePath : "DEFAULT (cacerts)"));
// DO NOT print the password in a real application, but for debugging:
// System.out.println("Trust Store Password: " + trustStorePassword);
		System.out.println("-----------------------------------");
	}

}
