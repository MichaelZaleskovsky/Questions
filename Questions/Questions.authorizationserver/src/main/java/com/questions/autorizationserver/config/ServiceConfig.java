package com.questions.autorizationserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
	
	@Value("${signing.key}")
	private String jwtSigningKey = "";

	public String getJwtSigningKey() {
		return jwtSigningKey;
	}
	
	

}
