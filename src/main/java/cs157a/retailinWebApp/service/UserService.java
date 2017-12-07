package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cs157a.retailinWebApp.entity.Department;
import cs157a.retailinWebApp.entity.Users;

@Service
public interface UserService {
	public List<Users> getUsers();
	
	public void saveUser(Integer deptID, Users user);
	
	public Users getUser(Integer empID);

	public void deleteUser(Integer empID);
}
