package com.questions.zuulserver.interceptor;

import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

public class UserContextHolder {
	private static final ThreadLocal<UserContext> userContext = new ThreadLocal<>();
	
	public static final UserContext getContext() {
		UserContext context = userContext.get();
		
		if(context == null) {
			context = new UserContext();
			userContext.set(context);
		}
		
		return context;
	}
	
	public static final void setContext(@NonNull UserContext context) {
		userContext.set(context);
	}

}
