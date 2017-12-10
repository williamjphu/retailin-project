package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs157a.retailinWebApp.dao.UserDAO;
import cs157a.retailinWebApp.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	@Override
	public void deleteUser(Integer empID) {
		userDao.deleteUser(empID);
	}
	
	@Override
	public User getUserById(Integer empID) {
		return userDao.getUserById(empID);
	}
}
