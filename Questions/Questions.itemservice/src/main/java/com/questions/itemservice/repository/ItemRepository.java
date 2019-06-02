package com.questions.itemservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.questions.itemservice.model.Item;
import com.questions.itemservice.model.User;

@Transactional
public interface ItemRepository extends CrudRepository<Item, Long> {
	List<Item> findByUser(User user);
	Item findByName(String name);

}
