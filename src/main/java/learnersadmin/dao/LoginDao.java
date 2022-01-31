package learnersadmin.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoginDao {

	
	public LoginDao() {
		super();
	}	
	
	/**
	 * Check session for login
	 * @param request HttpServletRequest request
	 * @return
	 */
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
		
		return status;
	}
	
	
}
