package com.questions.userservice.service;

import com.questions.userservice.model.User;

public interface UserService {
	
	User createUser(User user);
	
	User getUserByUsername(String username);

}
