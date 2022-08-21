package com.linecorp.analyticsengineer;

import com.linecorp.analyticsengineer.service.StorageProperties;
import com.linecorp.analyticsengineer.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class AnalyticsEngineerApplication {
	public static void main(String[] args) {
		SpringApplication.run(AnalyticsEngineerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return args -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
