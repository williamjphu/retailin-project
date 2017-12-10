package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs157a.retailinWebApp.dao.CategoryDAO;
import cs157a.retailinWebApp.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO categoryDao;
	
	@Override
	public List<Category> listCategories() {
		return categoryDao.listCategories();
	}

	@Override
	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}

	@Override
	public void deleteCategory(Integer deptID) {
		categoryDao.deleteCategory(deptID);
	}

	@Override
	public Category getCategoryById(Integer deptID) {
		return categoryDao.getCategoryById(deptID);
	}
}
