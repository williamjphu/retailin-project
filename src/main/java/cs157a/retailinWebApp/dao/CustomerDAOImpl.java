package cs157a.retailinWebApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cs157a.retailinWebApp.entity.Customer;

@Transactional
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> queries = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = queries.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(Integer phoneNo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer cust = currentSession.get(Customer.class, phoneNo);
		return cust;
	}

	@Override
	public void deleteCustomer(Integer phoneNo) {
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where phoneNumber=:customerID");
		theQuery.setParameter("customerID", phoneNo);
		// execute query
		theQuery.executeUpdate();
	}
}
