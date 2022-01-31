package learnersadmin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learnersadmin.dao.ClassesDao;
import learnersadmin.dao.LoginDao;
import learnersadmin.model.ClassesModel;

/**
 * Servlet implementation class ClassesController
 */
@WebServlet(urlPatterns = { "/classes/create", "/classes/insert", "/classes/edit", "/classes/update", "/classes/index",
		"/classes/delete" })

public class ClassesController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ClassesDao classesDao;

	public void init() {
		classesDao = new ClassesDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (LoginDao.sessionCheck(request) == 0) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			String action = request.getServletPath();

			try {
				switch (action) {
				case "/classes/create":
					displayForm(request, response);
					System.out.println("create");
					break;
				case "/classes/insert":
					insert(request, response);
					System.out.println("insert");
					break;
				case "/classes/edit":
					showEditForm(request, response);
					break;
				case "/classes/update":
					update(request, response);
					break;
				case "/classes/index":
					listClasses(request, response);
					break;
				case "/classes/delete":
					delete(request, response);
					break;
				}
			} catch (Exception ex) {
				throw new ServletException(ex);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (LoginDao.sessionCheck(request) == 0) {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	}

	/**
	 * Display from from class
	 * 
	 * @param request servlet request
	 * @param response 
	 * @throws ServletException
	 * @throws IOException
	 */

	private void displayForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classes/create.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * Save new entry for class
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClassesModel c = new ClassesModel();
		c.setClassName(request.getParameter("className"));
		c.setClassNumber(request.getParameter("classNumber"));
		c.setClassShift(request.getParameter("classShift"));
		ClassesDao.save(c);
		response.sendRedirect(request.getContextPath() + "/classes/index");

	}

	/**
	 * Save updated data for the class
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		ClassesModel c = new ClassesModel();

		c.setId(id);
		c.setClassName(request.getParameter("className"));
		c.setClassNumber(request.getParameter("classNumber"));
		c.setClassShift(request.getParameter("classShift"));

		ClassesDao.update(c);
		response.sendRedirect(request.getContextPath() + "/classes/index");

	}

	/**
	 * List all the classes for the index view
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listClasses(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<ClassesModel> listClasses = ClassesDao.getAllClasses();
		request.setAttribute("listClasses", listClasses);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/classes/index.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * Display update form
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		ClassesModel updateClass = ClassesDao.getClasses(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/classes/update.jsp");
		request.setAttribute("updateClass", updateClass);
		dispatcher.forward(request, response);

	}

	/**
	 * Delete Class Record from Id
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		classesDao.deleteClasses(id);
		response.sendRedirect(request.getContextPath() + "/classes/index");
	}

}
