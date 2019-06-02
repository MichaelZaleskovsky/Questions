package com.questions.userservice.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questions.userservice.model.Role;
import com.questions.userservice.model.User;
import com.questions.userservice.model.UserRole;
import com.questions.userservice.repository.UserRepository;
import com.questions.userservice.service.UserService;
import com.questions.userservice.utility.SecurityUtility;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		User localUser = userRepository.findByUsername(user.getUsername());
		
		if (localUser != null) {
			LOG.info("User with name {} already exist!", user.getUsername());
		} else {
			Set<UserRole> userRoles = new HashSet<>();
			Role localRole = new Role();
			localRole.setRoleId(1);
			UserRole localUserRole = new UserRole(user, localRole);
			userRoles.add(localUserRole);
			user.getUserRoles().addAll(userRoles);
			
			Date today = new Date();
			user.setJoinDate(today);
			
			String encriptedPassword = SecurityUtility.passwordEncoder().encode(user.getPassword());
			user.setPassword(encriptedPassword);
			localUser = userRepository.save(user);
			
		}
		
		return localUser;
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
