package org.gotprint.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	
	private String email;
	private String password;
	
	private List<Notes> userNotes = new ArrayList<Notes>();
	
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Notes> getUserNotes() {
		return userNotes;
	}
	public void setUserNotes(List<Notes> userNotes) {
		this.userNotes = userNotes;
	}
	public void addNotes(Notes notes){
		notes.setUser(this);
		userNotes.add(notes);
	}

}
