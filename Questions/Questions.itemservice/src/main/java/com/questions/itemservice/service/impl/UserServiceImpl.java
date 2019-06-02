package com.questions.itemservice.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questions.itemservice.repository.UserRepository;
import com.questions.itemservice.service.UserService;
import com.questions.itemservice.model.Role;
import com.questions.itemservice.model.User;
import com.questions.itemservice.model.UserRole;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
