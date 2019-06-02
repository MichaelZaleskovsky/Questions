package com.questions.itemservice.service;

import java.io.IOException;
import java.util.List;

import com.questions.itemservice.model.Item;
import com.questions.itemservice.model.User;

public interface ItemService {
	Item addItemByUser(Item item, String username);
	List<Item> getAllItems();
	List<Item> getItemsByUsername(String username);
	Item getItemById(long id);
	Item updateItem(Item item) throws IOException;
	void deleteItemById(long id);
	
	User getUserByUsername(String username);
}
