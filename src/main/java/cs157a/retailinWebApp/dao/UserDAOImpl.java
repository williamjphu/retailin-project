package cs157a.retailinWebApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

///import cs157a.retailinWebApp.entity.Authorities;
import cs157a.retailinWebApp.entity.Users;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<Users> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Users> query = currentSession.createQuery("from Users", Users.class); 
		List<Users> users = query.getResultList();
		return users;
	}

	@Override
	public void saveUser(Users theUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the customer
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public Users getUser(Integer empID) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve from database
		Users user = currentSession.get(Users.class, empID);
		
		// save/update the customer ... finally LOL
		return user;
	}

	@Override
	public void deleteUser(Integer theEmpID) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Users where empID=:employeeID");
		theQuery.setParameter("employeeID", theEmpID);
		
		// execute query
		theQuery.executeUpdate();
	}

}
