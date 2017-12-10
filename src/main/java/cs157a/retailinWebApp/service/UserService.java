package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import cs157a.retailinWebApp.entity.User;

@Service
public interface UserService {
	public List<User> getUsers();
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(Integer empID);
	public User getUserById(Integer empID);
}
