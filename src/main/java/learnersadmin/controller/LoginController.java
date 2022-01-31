package learnersadmin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import learnersadmin.dao.LoginDao;


/**
 * Servlet implementation class LoginController
 */

/**
 * Servlet implementation class ClassesController
 */
@WebServlet(urlPatterns = {"/login","/logout","/logincheck"})

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		System.out.println(action);
		
		try {
			switch(action) {
			case "/login":
				
				if(LoginDao.sessionCheck(request) == 1 ) {
					response.sendRedirect(request.getContextPath() + "/");
				} else {	
				
					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");	        
			        dispatcher.forward(request, response);
				}
			
			break;
			case "/logincheck":
				String user = request.getParameter("username");
				String pwd = request.getParameter("password");
				System.out.println(user);
				System.out.println(pwd);
				if(user.equals("admin") && pwd.equals("password")) {
					  HttpSession session = request.getSession(true);
					  session.setAttribute("user", user);
					  System.out.println("login here");
					  response.sendRedirect(request.getContextPath() + "/");
					  System.out.println("Username password matched");
				} else {
					request.setAttribute("error", "Username password not matched");
					System.out.println("Username password not matched");
					response.sendRedirect(request.getContextPath() + "/login?error=up");	
				}
			break;
			case "/logout":				
				HttpSession session =  request.getSession(false);
				if(session != null) {				
				    // Invalidate the session and removes any attribute related to it		
					session.removeAttribute("user");
					session.invalidate();
					System.out.println("logout invalidate: ");
					response.sendRedirect(request.getContextPath() + "/login");	
				} else {
					System.out.println("logout session: " + session);
				}
			break;
			}
		} catch (Exception ex) {
            throw new ServletException(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		
			doGet(request, response);
		
		
	}

}
