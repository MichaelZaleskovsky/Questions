package com.questions.itemservice.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questions.itemservice.model.Item;
import com.questions.itemservice.model.User;
import com.questions.itemservice.repository.ItemRepository;
import com.questions.itemservice.service.ItemService;
import com.questions.itemservice.service.UserService;

@Service
public class ItemServiceImpl implements ItemService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserService userService;

	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item addItemByUser(Item item, String username) {
		Item localItem = itemRepository.findByName(item.getName());
		
		if(localItem != null) {
			LOG.info("Item with name {} already exist", item.getName());
			return null;
		} else {
			Date date = new Date();
			item.setAddDate(date);
			
			User user = userService.getUserByUsername(username);
			item.setUser(user);
			Item newItem = itemRepository.save(item);
			return newItem;
		}
	}

	@Override
	public List<Item> getAllItems() {
		return (List<Item>) itemRepository.findAll();
	}

	@Override
	public List<Item> getItemsByUsername(String username) {
		User user = userService.getUserByUsername(username);
		return (List<Item>) itemRepository.findByUser(user);
	}

	@Override
	public Item getItemById(long id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public Item updateItem(Item item) throws IOException {
		Item localItem = getItemById(item.getId());
		
		if(localItem == null) {
			throw new IOException("Item was not found");
		} else {
			localItem.setName(item.getName());
			localItem.setItemCondition(item.getItemCondition());
			localItem.setStatus(item.getStatus());
			localItem.setDescription(item.getDescription());
			return itemRepository.save(localItem);
		}
	}

	@Override
	public void deleteItemById(long id) {
		itemRepository.deleteById(id);
	}

	@Override
	public User getUserByUsername(String username) {
		return userService.getUserByUsername(username);
	}

}
