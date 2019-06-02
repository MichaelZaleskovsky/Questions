package com.questions.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.questions.userservice.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
