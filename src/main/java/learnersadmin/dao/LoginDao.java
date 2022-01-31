package learnersadmin.dao;


import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import learnersadmin.model.UserModel;

public class LoginDao {

	
	public LoginDao() {
		super();
	}
	
	
	public static int login(String username, String password) {
		
		int status = 0;
		
		Transaction transaction = null;
		
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			  
			Query query = session.createQuery("from user where username=:username and password=:password");
			query.setParameter("username", "admin");
			query.setParameter("password", "password");
			UserModel user = (UserModel)query.getSingleResult();
			
			 if(user!=null) {
				 status = 1;
			       System.out.println("username and password are valid");
			    }else {
			    	status = 3;
			       System.out.println("username and password are not valid");
			    }		
			
			 transaction.commit();			
			
		} catch (Exception ex) {
			status = 2;
			ex.printStackTrace();
		}
		
		return status;
		
	}
	
	public static int sessionCheck(HttpServletRequest request) {
		
		int status = 0;
		
		HttpSession session = request.getSession();
		String sessionUser = null;
		
		if(session != null) {
			sessionUser =(String)session.getAttribute("user"); 
		}
		
		
	    if (sessionUser == null){
	        status = 0;
	      } else {
	    	status = 1;
	    }
	    
		System.out.println("0. Status LoginDao: " + status);
		//System.out.println("1. Session LoginDao: " + session.getId());
		//System.out.println(sessionUser);
		return status;
	}
	
	
}
