package com.questions.configurer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurerApplication.class, args);

	}

}
