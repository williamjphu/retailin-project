package cs157a.retailinWebApp.service;

import java.util.List;

import cs157a.retailinWebApp.entity.Category;

public interface CategoryService {
	public List<Category> listCategories();
	public void addCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(Integer deptID);
	public Category getCategoryById(Integer deptID);
}
