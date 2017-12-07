package cs157a.retailinWebApp.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cs157a.retailinWebApp.entity.Item;

@Transactional
@Repository
public class ItemDAOImpl implements ItemDAO {
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public List<Item> getItems() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Item> query = currentSession.createQuery("from Item", Item.class); 
		List<Item> items = query.getResultList();
		return items;
	}

	@Override
	public void saveItem(Item item) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
//		if(theUser.empID < 1) {
			SQLQuery q = currentSession.createSQLQuery("insert into items(item_name, description, price, discount, quantity, category_id)" + 
					" values(?, ?, ?, ?, ?, ?)");
			q.setParameter(0, item.getItemName());
			q.setParameter(1, item.getDescription());
			q.setParameter(2, item.getPrice());
			q.setParameter(3, item.getDiscount());
			q.setParameter(4, item.getQuantity());
			q.setParameter(5, item.getCategoryID());
			q.executeUpdate();
//			SQLQuery q3 = currentSession.createSQLQuery("insert into categories(category_name, category_description) select category_id from items order by category_id desc limit 1");
//			q3.executeUpdate();
//		}
//		else {
//			SQLQuery q = currentSession.createSQLQuery("update users set first_name = ?, last_name = ?, password = ?, email = ?, phone_number = ?, enabled = ?, authority = ?, department_id = ? where username = ?");
//			q.setParameter(0, theUser.getFirstName());
//			q.setParameter(1, theUser.getLastName());
//			q.setParameter(2, theUser.getPassword());
//			q.setParameter(3, theUser.getEmail());
//			q.setParameter(4, theUser.getPhoneNumber());
//			q.setParameter(5, theUser.getEnabled());
//			q.setParameter(6, theUser.getAuthority());
//			q.setParameter(7, theUser.getDepartmentID());
//			q.setParameter(8, theUser.empID);
//			q.executeUpdate();
//			SQLQuery q3 = currentSession.createSQLQuery("update authorities set authority = ? where username = ?");
//			q3.setParameter(0, theUser.getAuthority());
//			q3.setParameter(1, theUser.empID);
//			q3.executeUpdate();
//		}
		// save/update the customer
//		currentSession.saveOrUpdate(item);
		
	}

	@Override
	public Item getItem(String itemN) {
		Session currentSession = sessionFactory.getCurrentSession();
		Item item = currentSession.get(Item.class, itemN);
		return item;
	}

	@Override
	public void deleteItem(String itemN) {
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Item where itemName=:itemNAME");
		theQuery.setParameter("itemNAME", itemN);
		// execute query
		theQuery.executeUpdate();
	}
}
