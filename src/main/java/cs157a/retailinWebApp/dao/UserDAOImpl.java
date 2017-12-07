package cs157a.retailinWebApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cs157a.retailinWebApp.entity.Department;
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
	public void saveUser(Integer deptID, Users theUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
//		Query q = currentSession.createQuery("INSERT INTO Users(lastName, firstName, password, email, phoneNumber, authority, department) values (?, ?, ?, ?, ?, ?, ?)");
//		q.setParameter(0, theUser.getFirstName());
//		q.setParameter(1, theUser.getLastName());
//		q.setParameter(2, theUser.getPassword());
//		q.setParameter(3, theUser.getEmail());
//		q.setParameter(4, theUser.getPhoneNumber());
//		q.setParameter(5, theUser.getAuthority());
//		q.setParameter(6, theUser.getDepartment());
//		q.executeUpdate();
		
		//Department existingDept = currentSession.get(Department.class, deptID);
		//theUser.setDepartment(existingDept);
//		int id = 1;
	//		currentSession.get(Department.class, id); 
//		dept.add(theUser);
//		Department dept = new Department();
//		dept.add(theUser);
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
