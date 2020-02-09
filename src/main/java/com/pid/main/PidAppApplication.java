package com.pid.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.pid.main" })
@EnableJpaRepositories(basePackages = { "com.pid.main.repository" })
@EntityScan("com.pid.main.model")
public class PidAppApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PidAppApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PidAppApplication.class, args);
	}

}
