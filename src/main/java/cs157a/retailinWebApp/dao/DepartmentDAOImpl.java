package cs157a.retailinWebApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs157a.retailinWebApp.entity.Department;

@Transactional
@Service
@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	@Autowired
	private SessionFactory sessionFactory;
//	= new Configuration()
//										.configure("webapp-servlet.xml")
//										.addAnnotatedClass(Users.class)
//										.addAnnotatedClass(Department.class)
//										.buildSessionFactory();
	
	@Override
	public List<Department> getDepartments() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Department> query = currentSession.createQuery("from Department", Department.class);
		List<Department> departments = query.getResultList();
		return departments;
	}
	
	@Override
	public void saveDepartment(Department theDeparment) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theDeparment);
	}

	@Override
	public Department getDepartment(Integer deptID) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// retrieve from database
		Department department = currentSession.get(Department.class, deptID);
		return department;
	}

	@Override
	public void deleteDepartment(Integer deptID) {
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Department where departmentID=:deptID");
		theQuery.setParameter("deptID", deptID);
		// execute query
		theQuery.executeUpdate();
	}
}