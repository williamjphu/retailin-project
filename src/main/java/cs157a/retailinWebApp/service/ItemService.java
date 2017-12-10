package cs157a.retailinWebApp.service;

import java.util.List;

import cs157a.retailinWebApp.entity.Item;

public interface ItemService {
	public List<Item> getItems();
	public void addItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(int itemId);
	public Item findItemById(int itemId);
}
