package com.questions.autorizationserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.questions.autorizationserver.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

}
