package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.User;

public interface UserDAO {
	public List<User> getUsers();
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(Integer empID);
	public User getUserById(Integer empID);
}
