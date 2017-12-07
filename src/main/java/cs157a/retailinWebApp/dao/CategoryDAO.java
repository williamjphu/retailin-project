package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.Category;

public interface CategoryDAO {
	public List<Category> getCategories();
	
	public void saveCategory(Category Category);
	
	//public Users getUser(String username);
	public Category getCategory(Integer catID);
	
	//public void deleteUser(String username);
	public void deleteCategory(Integer catID);
}
