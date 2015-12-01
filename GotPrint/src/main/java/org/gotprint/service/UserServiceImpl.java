package org.gotprint.service;

import java.util.List;

import org.gotprint.dao.UserDao;
import org.gotprint.dao.UserDaoImpl;
import org.gotprint.model.Notes;
import org.gotprint.model.User;

public class UserServiceImpl implements UserService{

	UserDao userDao = new UserDaoImpl();
	public User checkUserCredentials(String userData) {
		return userDao.checkUserCredentials(userData);
		
	}

	public void addDefaultUsers() {
		userDao.addDefaultUsers();
	}

	@Override
	public void addNotes(String userData,String userNotes) {
		userDao.addNotes(userData,userNotes);
		
	}

	@Override
	public List<Notes> getUserNotes(String userData) {
		
		return userDao.getUserNotes(userData);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}


	

}
