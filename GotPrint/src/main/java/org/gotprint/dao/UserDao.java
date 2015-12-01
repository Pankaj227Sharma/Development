package org.gotprint.dao;

import java.util.List;

import org.gotprint.model.Notes;
import org.gotprint.model.User;

public interface UserDao {
	
	public User checkUserCredentials(String userData);
	public void addDefaultUsers();
	public void addNotes(String userData,String userNotes);
	public List<Notes> getUserNotes(String userData);
	public void addUser(User user);

}
