package com.questions.zuulserver.interceptor;

import org.springframework.stereotype.Component;

@Component
public class UserContext {
	public static final String CORRELATION_ID = "q_correlation_id";
	public static final String AUTH_TOKEN = "authorization";
	public static final String USER_ID = "q_user_id";
	
	private String correlationId = new String();
	private String authToken = new String();
	private String userId = new String();
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
