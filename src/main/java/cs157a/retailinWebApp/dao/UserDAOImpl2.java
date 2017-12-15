//package cs157a.retailinWebApp.dao;
//
//import java.util.List;
//
//import org.hibernate.SQLQuery;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
/////import cs157a.retailinWebApp.entity.Authorities;
//import cs157a.retailinWebApp.entity.Users;
//
//@Repository
//public class UserDAOImpl implements UserDAO {
//	@Autowired
//	private SessionFactory sessionFactory; 
//
//	@Override
//	public List<Users> getUsers() {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<Users> query = currentSession.createQuery("from Users", Users.class); 
//		List<Users> users = query.getResultList();
//		return users;
//	}
//
//	@Override
//	public void saveUser(Users theUser) {
//		// get current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//		if(theUser.empID < 1) {
//			SQLQuery q = currentSession.createSQLQuery("insert into users(first_name, last_name, password, email, phone_number, enabled, authority, department_id)" + 
//					" values(?, ?, ?, ?, ?, ?, ?, ?)");
//			q.setParameter(0, theUser.getFirstName());
//			q.setParameter(1, theUser.getLastName());
//			q.setParameter(2, theUser.getPassword());
//			q.setParameter(3, theUser.getEmail());
//			q.setParameter(4, theUser.getPhoneNumber());
//			q.setParameter(5, theUser.getEnabled());
//			q.setParameter(6, theUser.getAuthority());
//			q.setParameter(7, theUser.getDepartmentID());
//			q.executeUpdate();
//			SQLQuery q3 = currentSession.createSQLQuery("insert into authorities(username, authority) select username, authority from users order by username desc limit 1");
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
//		// save/update the customer
//		//currentSession.saveOrUpdate(theUser);
//	}
//
//	@Override
//	public Users getUser(Integer empID) {
//		// get current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//
//		// retrieve from database
//		Users user = currentSession.get(Users.class, empID);
//
//		// save/update the customer ... finally LOL
//		return user;
//	}
//
//	@Override
//	public void deleteUser(Integer theEmpID) {
//		// get the current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//
//		// delete object with primary key
//		Query theQuery = currentSession.createQuery("delete from Users where empID=:employeeID");
//		theQuery.setParameter("employeeID", theEmpID);
//
//		// execute query
//		theQuery.executeUpdate();
//	}
//
//}
