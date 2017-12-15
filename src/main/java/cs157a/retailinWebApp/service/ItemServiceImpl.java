package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs157a.retailinWebApp.dao.ItemDAO;
import cs157a.retailinWebApp.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDAO itemDao;
	
	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}

	@Override
	public void addItem(Item item) {
		itemDao.addItem(item);
	}

	@Override
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}

	@Override
	public void deleteItem(int itemId) {
		itemDao.deleteItem(itemId);
	}

	@Override
	public Item findItemById(int itemId) {
		return itemDao.findItemById(itemId);
	}
}
