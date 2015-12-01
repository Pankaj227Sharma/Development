package org.gotprint.restservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.gotprint.model.User;
import org.gotprint.service.UserService;
import org.gotprint.service.UserServiceImpl;

@Path("userRest")
public class UserRest {
	
	@GET
	@Path("getUser/{userData}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getAllUsers(@PathParam("userData") String userData){
		System.out.println("Webservice Called");
		UserService user = new UserServiceImpl();
		return user.checkUserCredentials(userData);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public User addUser(MultivaluedMap<String, String> formParams){
		//Here we can add logic to add the new user
		return null;
	}
	
	
	
	
	
	
	

}
