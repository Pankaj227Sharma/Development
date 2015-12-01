package org.gotprint.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gotprint.hibernate.HibernateUtil;
import org.gotprint.model.Notes;
import org.gotprint.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDaoImpl implements UserDao{
	
	Session session = null;
	SessionFactory sessionFactory = null;
	
	
	public User checkUserCredentials(String userData) {
		
		List<User> userList = new ArrayList<User>();
		if(sessionFactory==null)
			sessionFactory = HibernateUtil.getSessionFactory();
		//For the first time insert the default users in the user table
		session=sessionFactory.openSession();
		try{
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		
		
		
		userList =(List<User>) criteria.list();
		
		if(userData.contains("@")){
			//Check for email id
			System.out.println("Checking for email address");
			for(User user:userList){
				if(user.getEmail().equalsIgnoreCase(userData)){
					return user;
				}
			}
		}else{
			//check for name
			System.out.println("Checking for name");
			for(User user:userList){
				if(user.getFirstName().equalsIgnoreCase(userData)){
					return user;
				}
			}
		}
		}finally{
			session.flush();
			session.close();
			
		}
		return null;
		
	}

	public void addDefaultUsers() {
		if(sessionFactory==null)
			sessionFactory = HibernateUtil.getSessionFactory();
		//For the first time insert the default users in the user table
		session=sessionFactory.openSession();
		try{
			session.beginTransaction();
			
			User user = new User();
			user.setFirstName("Pankaj");
			user.setLastName("Kumar");
			user.setEmail("pankaj227sharma@gmail.com");
			user.setPassword("pankaj");
			
			User user1 = new User();
			user1.setFirstName("gotprint");
			user1.setLastName("Print");
			user1.setEmail("trial@gotprint.com");
			user1.setPassword("gotprint");
			
			session.save(user);
			
			session.save(user1);
			session.getTransaction().commit();
		}finally{
			session.flush();
			session.close();
		}
		
		
		
	}

	@Override
	public void addNotes(String userData,String userNotes) {
		User user = checkUserCredentials(userData);
		if(sessionFactory==null)
			sessionFactory = HibernateUtil.getSessionFactory();
		//For the first time insert the default users in the user table
		try{
			session=sessionFactory.openSession();
			session.beginTransaction();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			   //get current date time with Date()
			Date date = new Date();
			Notes notes = new Notes();
			notes.setNote(userNotes);
			notes.setCreationTime(date);
			
			
			user.addNotes(notes);		
					
			
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		}finally{
			session.flush();
			session.close();
			
		}
		
		
		
		
		
	}

	@Override
	public List<Notes> getUserNotes(String userData) {
		List<Notes> list=null;
		if(sessionFactory==null)
			sessionFactory = HibernateUtil.getSessionFactory();
		//For the first time insert the default users in the user table
		session=sessionFactory.openSession();
		try{
			session.beginTransaction();
			list =session.createCriteria(Notes.class).list();
		
		}finally{
			session.flush();
			session.close();
		}
		return list;
	}

	@Override
	public void addUser(User user) {
		if(sessionFactory==null)
			sessionFactory = HibernateUtil.getSessionFactory();
		//For the first time insert the default users in the user table
		session=sessionFactory.openSession();
		try{
			session.beginTransaction();
			
			session.save(user);
			
			session.getTransaction().commit();
		}finally{
			session.flush();
			session.close();
		}
		
		
	}

	

}
