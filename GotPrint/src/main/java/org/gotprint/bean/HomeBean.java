package org.gotprint.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.gotprint.model.Notes;
import org.gotprint.model.User;
import org.gotprint.service.UserService;
import org.gotprint.service.UserServiceImpl;

@ManagedBean
@SessionScoped
public class HomeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	private String userData;
	private User user;
	private boolean displayNotes;
	private List<Notes> notes = new ArrayList<Notes>();
	private String userNote;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	@PostConstruct
	public void init(){
		System.out.println("Initialization Done");
		userService.addDefaultUsers();
		if(userData==null){
		setDisplayNotes(false);
		}
	}
	
	public void addUser(){
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		userService.addUser(user);
		FacesContext.getCurrentInstance().addMessage("success", new FacesMessage("User Added Successfully"));
		
	}
	
	
	
	public void checkUser(){
		
		User userInfo = userService.checkUserCredentials(userData);
		
		if(userInfo==null){
			FacesContext.getCurrentInstance().addMessage("failure", new FacesMessage("It seems you have entered something wrong.. Please check "));
			setDisplayNotes(false);
		}else{
			setUser(userInfo);
			setDisplayNotes(true);
			List<Notes> notes = userService.getUserNotes(userData);
			if(notes!=null && notes.size()>0){
				System.out.println("Notes are there" + notes);
				setNotes(notes);
				setDisplayNotes(true);
			}else{
				setDisplayNotes(false);
				System.out.println("No Notes yet");
				FacesContext.getCurrentInstance().addMessage("failure", new FacesMessage("No notes created yet..Please add one "));
			}
		}
		
		
	}
	
	public void addNotes(){
		if(userNote.length()>0 && userData.length()>0){
		userService.addNotes(userData, userNote);
		}else{
			FacesContext.getCurrentInstance().addMessage("failure", new FacesMessage("Either User or User Note is Empty"));
		}
		checkUser();
	}



	public String getUserData() {
		return userData;
	}



	public void setUserData(String userData) {
		this.userData = userData;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

	public boolean isDisplayNotes() {
		return displayNotes;
	}

	public void setDisplayNotes(boolean displayNotes) {
		this.displayNotes = displayNotes;
	}

	public List<Notes> getNotes() {
		return notes;
	}

	public void setNotes(List<Notes> notes) {
		this.notes = notes;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUserNote() {
		return userNote;
	}

	public void setUserNote(String userNote) {
		this.userNote = userNote;
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
	
	
	
	
	
	

	
	
}