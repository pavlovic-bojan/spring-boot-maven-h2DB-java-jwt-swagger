package com.pavlovicbojan.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Initialize the Spring application instance
		SpringApplication app = new SpringApplication(DemoApplication.class);

		// Load .env values and prepare them for Spring environment
		Dotenv dotenv = Dotenv.configure().load();
		Map<String, Object> envProps = new HashMap<>();
		dotenv.entries().forEach(entry -> envProps.put(entry.getKey(), entry.getValue()));

		// Add .env properties to Spring Environment
		app.addInitializers(ctx -> {
			ConfigurableEnvironment env = ctx.getEnvironment();
			env.getPropertySources().addLast(new MapPropertySource("dotenvProperties", envProps));
		});

		// Start the application
		app.run(args);
	}
}
