package org.gotprint.service;

import java.util.List;

import org.gotprint.model.Notes;
import org.gotprint.model.User;

public interface UserService {

	public User checkUserCredentials(String userData);
	public void addDefaultUsers();
	public void addNotes(String userData,String userNotes);
	public List<Notes> getUserNotes(String userData);
	public void addUser(User user);
	public List<User> showAllUsers();
	
	
}
