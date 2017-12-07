package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.Item;

public interface ItemDAO {
	public List<Item> getItems();
	public void saveItem(Item item);
	public Item getItem(String itemN);
	public void deleteItem(String itemN);
}
