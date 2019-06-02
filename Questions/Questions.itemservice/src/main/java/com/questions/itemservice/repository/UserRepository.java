package com.questions.itemservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.questions.itemservice.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
