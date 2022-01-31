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

import learnersadmin.model.ClassesModel;
import learnersadmin.model.StudentModel;
import learnersadmin.dao.ClassesDao;
import learnersadmin.dao.LoginDao;
import learnersadmin.dao.StudentDao;

/**
 * Servlet implementation class StudentController
 */
@WebServlet(urlPatterns = { "/student/create", "/student/insert", "/student/edit", "/student/update", "/student/index",
		"/student/delete" })

public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
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
				case "/student/create":
					displayForm(request, response);
					System.out.println("create");
					break;
				case "/student/insert":
					insert(request, response);
					System.out.println("insert");
					break;
				case "/student/edit":
					showEditForm(request, response);
					break;
				case "/student/update":
					update(request, response);
					break;
				case "/student/index":
					listStudents(request, response);
					break;
				case "/student/delete":
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Display new entry form for student
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	private void displayForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("class_id", request.getParameter("class_id"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/student/create.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Save new entry for Student
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentModel s = new StudentModel();
		int class_id = Integer.parseInt(request.getParameter("class_id"));
		ClassesModel studentClasses = ClassesDao.getClasses(class_id);

		// Only valid class id can save students
		if (studentClasses == null) {
			request.setAttribute("classes_error", "class doesnot Exist");
		}

		s.setFullName(request.getParameter("fullname"));
		s.setEmail(request.getParameter("email"));
		s.setAge(Integer.parseInt(request.getParameter("age")));
		s.setClasses(studentClasses);
		StudentDao.save(s);
		response.sendRedirect(request.getContextPath() + "/student/index?class_id=" + class_id);

	}

	/**
	 * Display edit form for Student
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
		StudentModel updateStudent = StudentDao.getStudent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/student/update.jsp");
		request.setAttribute("updateStudent", updateStudent);
		dispatcher.forward(request, response);

	}

	/**
	 * Update data for student
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		int age = Integer.parseInt(request.getParameter("age"));
		StudentModel s = new StudentModel();

		int class_id = Integer.parseInt(request.getParameter("class_id"));
		ClassesModel studentClasses = ClassesDao.getClasses(class_id);

		s.setId(id);
		s.setFullName(request.getParameter("fullname"));
		s.setEmail(request.getParameter("email"));
		s.setAge(age);
		s.setClasses(studentClasses);

		StudentDao.update(s);
		response.sendRedirect(request.getContextPath() + "/student/index?class_id=" + request.getParameter("class_id"));

	}

	/**
	 * List all the students
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 */
	private void listStudents(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		int class_id = Integer.parseInt(request.getParameter("class_id"));
		List<StudentModel> listStudents = StudentDao.getAllStudents(class_id);

		ClassesModel studentClasses = ClassesDao.getClasses(class_id);

		request.setAttribute("listStudents", listStudents);
		request.setAttribute("classes", studentClasses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/student/index.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * Delete student Record from Id
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int class_id = Integer.parseInt(request.getParameter("class_id"));
		StudentDao.deleteStudent(id);
		response.sendRedirect(request.getContextPath() + "/student/index?class_id=" + class_id);
	}

}
