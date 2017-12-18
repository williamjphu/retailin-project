package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.Item;

public interface ItemDAO {
	public List<Item> getItems();
	public void addItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(int itemId);
	public Item findItemById(int itemId);
	public List<Item> getItems(Integer recId);
}
