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

import learnersadmin.dao.LoginDao;
import learnersadmin.dao.TeacherDao;
import learnersadmin.model.TeacherModel;

/**
 * Servlet implementation class TeacherController
 */
@WebServlet(urlPatterns = { "/teacher/create", "/teacher/insert", "/teacher/edit", "/teacher/update", "/teacher/index",
		"/teacher/delete" })
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeacherDao teacherDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		teacherDao = new TeacherDao();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (LoginDao.sessionCheck(request) == 0) {
			System.out.println("here :status :0");
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			doGet(request, response);
		}

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (LoginDao.sessionCheck(request) == 0) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			String action = request.getServletPath();
			System.out.println(action);
			System.out.println(request.getSession(false));

			try {
				switch (action) {
				case "/teacher/create":
					displayForm(request, response);
					System.out.println("create");
					break;
				case "/teacher/insert":
					insert(request, response);
					System.out.println("insert");
					break;
				case "/teacher/edit":
					showEditForm(request, response);
					break;
				case "/teacher/update":
					update(request, response);
					break;
				case "/teacher/index":
					listTeachers(request, response);
					break;
				case "/teacher/delete":
					delete(request, response);
					break;
				}
			} catch (Exception ex) {
				throw new ServletException(ex);
			}
		}
	}

	/**
	 * Display form for Teacher new entry
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void displayForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacher/create.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Save new entry for Teacher
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TeacherModel t = new TeacherModel();
		t.setFullName(request.getParameter("fullname"));
		t.setEmail(request.getParameter("email"));
		t.setPhoneNumber(request.getParameter("phone"));
		TeacherDao.save(t);
		response.sendRedirect(request.getContextPath() + "/teacher/index");

	}

	/**
	 * Update Teacher Data
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		TeacherModel t = new TeacherModel();
		t.setId(id);
		t.setFullName(fullname);
		t.setEmail(email);
		t.setPhoneNumber(phone);
		TeacherDao.update(t);
		response.sendRedirect(request.getContextPath() + "/teacher/index");

	}

	/**
	 * List all Teacher
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listTeachers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<TeacherModel> listTeacher = TeacherDao.getAllTeacher();
		request.setAttribute("listTeacher", listTeacher);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacher/index.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * Display Edit form
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
		TeacherModel existingUser = TeacherDao.getTeacher(id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacher/update.jsp");

		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	/**
	 * Delete teacher Record from Id
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		teacherDao.deleteTeacher(id);
		response.sendRedirect(request.getContextPath() + "/teacher/index");
	}

}
