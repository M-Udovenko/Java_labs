package ua.edu.lab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiquibaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiquibaseDemoApplication.class, args);
		System.out.println("\n=== Spring Boot Application Started ===");
		System.out.println("Server running on: http://localhost:8080");
		System.out.println("API endpoints:");
		System.out.println("  GET  /api/products");
		System.out.println("  GET  /api/products/{code}");
		System.out.println("  POST /api/products");
		System.out.println("========================================\n");
	}
}