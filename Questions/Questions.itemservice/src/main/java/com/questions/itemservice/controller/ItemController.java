package com.questions.itemservice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.questions.itemservice.model.Item;
import com.questions.itemservice.model.User;
import com.questions.itemservice.service.ItemService;
import com.questions.itemservice.service.UserService;

@RestController
@RequestMapping("/v1/item")
public class ItemController {
	
	@Autowired
	UserService userservice;
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Item addItem(@RequestBody Item item) {
		
		String username = "asmith";
		
		return itemService.addItemByUser(item, username);
	}

	@RequestMapping("/itemsByUser")
	public List<Item> getItemsByUser() {
		
		String username = "asmith";
		
		return itemService.getItemsByUsername(username);
	}

	@RequestMapping("/all")
	public List<Item> getAllItems() {
		
		return itemService.getAllItems();
	}

	@RequestMapping("/{id}")
	public Item getItemById(@PathVariable long id) {
		
		return itemService.getItemById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Item updateItem(@PathVariable long id, @RequestBody Item item) throws IOException {
		
		item.setId(id);
		
		return itemService.updateItem(item);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable long id) throws IOException {
		
		itemService.deleteItemById(id);
	}

	@RequestMapping(value = "/use/{username}")
	public User getUserByUsername(@PathVariable String username) {
		
		return itemService.getUserByUsername(username);
	}

}
