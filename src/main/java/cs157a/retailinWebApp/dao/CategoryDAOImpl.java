package cs157a.retailinWebApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs157a.retailinWebApp.entity.Category;

@Transactional
@Service
@Repository
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getCategories() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Category> queries = currentSession.createQuery("from Category", Category.class);
		List<Category> categories = queries.getResultList();
		return categories;
	}

	@Override
	public void saveCategory(Category category) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(category);
	}

	@Override
	public Category getCategory(Integer catID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Category category = currentSession.get(Category.class, catID);
		return category;
	}

	@Override
	public void deleteCategory(Integer cateID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Category where categoryID=:catID");
		theQuery.setParameter("catID", cateID);
		theQuery.executeUpdate();
	}
}
