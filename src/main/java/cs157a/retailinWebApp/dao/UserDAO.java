package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.Department;
import cs157a.retailinWebApp.entity.Users;

public interface UserDAO {
	public List<Users> getUsers();
	
	public void saveUser(Integer deptID, Users user);
	//public Users getUser(String username);
	public Users getUser(Integer empID);
	
	//public void deleteUser(String username);
	public void deleteUser(Integer empID);
}
