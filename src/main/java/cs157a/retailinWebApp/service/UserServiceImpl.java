package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs157a.retailinWebApp.dao.UserDAO;
import cs157a.retailinWebApp.entity.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	@Override
	@Transactional
	public List<Users> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(Users user) {
		userDao.saveUser(user);
	}

	@Override
	@Transactional
	public Users getUser(Integer empID) {
		return userDao.getUser(empID);
	}

	@Override
	@Transactional
	public void deleteUser(Integer empID) {
		userDao.deleteUser(empID);
	}

}
