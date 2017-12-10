package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cs157a.retailinWebApp.dao.ItemDAO;
import cs157a.retailinWebApp.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDAO itemDao;
	
//	@Autowired
//	@Transactional
//	public void setItemDAO(ItemDAO itemDAO) {
//		this.itemDao = itemDAO;
//	}
	
	@Override
//	@Transactional
	public List<Item> getItems() {
		return itemDao.getItems();
	}

	@Override
//	@Transactional
	public void addItem(Item item) {
		itemDao.addItem(item);
	}

	@Override
//	@Transactional
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}

	@Override
//	@Transactional
	public void deleteItem(String itemName) {
		itemDao.deleteItem(itemName);
	}

	@Override
//	@Transactional
	public Item findItemById(String itemName) {
		return itemDao.findItemById(itemName);
	}
}
