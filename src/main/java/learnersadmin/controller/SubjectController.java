package learnersadmin.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import learnersadmin.dao.SubjectDao;
import learnersadmin.dao.TeacherDao;
import learnersadmin.model.ClassesModel;
import learnersadmin.model.SubjectModel;
import learnersadmin.model.TeacherModel;

/**
 * Servlet implementation class SubjectController
 */
@WebServlet(urlPatterns = { "/subject/create", "/subject/insert", "/subject/edit", "/subject/update", "/subject/index",
		"/subject/delete" })

public class SubjectController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// private SubjectDao subjectsDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubjectController() {
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
			// TODO Auto-generated method stub
			String action = request.getServletPath();

			int class_id = Integer.parseInt(request.getParameter("class_id"));
			ClassesModel subjectClass = ClassesDao.getClasses(class_id);

			if (subjectClass == null) {
				PrintWriter pwriter = response.getWriter();
				pwriter.print("Class not Exist, create class first");
			} else {
				try {
					switch (action) {
					case "/subject/create":
						displayForm(request, response);
						break;
					case "/subject/insert":
						insert(request, response);
						break;
					case "/subject/edit":
						showEditForm(request, response);
						break;
					case "/subject/update":
						update(request, response);
						break;
					case "/subject/index":
						listSubject(request, response);
						break;
					case "/subject/delete":
						delete(request, response);
						break;

					}
				} catch (Exception ex) {
					throw new ServletException(ex);
				}
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
		if (LoginDao.sessionCheck(request) == 0) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			doGet(request, response);
		}
	}

	/**
	 * Display form for new entry
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void displayForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/subject/create.jsp");
		List<TeacherModel> listTeacher = TeacherDao.getAllTeacher();

		int class_id = Integer.parseInt(request.getParameter("class_id"));
		ClassesModel subjectClass = ClassesDao.getClasses(class_id);

		request.setAttribute("listTeacher", listTeacher);
		request.setAttribute("subjectClass", subjectClass);
		request.setAttribute("class_id", class_id);

		dispatcher.forward(request, response);
	}

	/**
	 * Save new entry for subject with class
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SubjectModel s = new SubjectModel();

		int class_id = Integer.parseInt(request.getParameter("class_id"));
		ClassesModel subjectClass = ClassesDao.getClasses(class_id);

		int teacher_id = Integer.parseInt(request.getParameter("teacher"));
		TeacherModel teacher = TeacherDao.getTeacher(teacher_id);

		s.setSubject(request.getParameter("subjectName"));
		s.setSubjectTime(request.getParameter("subjectTime"));
		s.setClasses(subjectClass);
		s.setTeacher(teacher);
		SubjectDao.save(s);
		response.sendRedirect(request.getContextPath() + "/subject/index?class_id=" + request.getParameter("class_id"));

	}

	/**
	 * List all the Subject
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException
	 */

	private void listSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		int class_id = Integer.parseInt(request.getParameter("class_id"));
		List<SubjectModel> listSubject = SubjectDao.getAllSubjects(class_id);
		ClassesModel subjectClasses = ClassesDao.getClasses(class_id);

		request.setAttribute("listSubject", listSubject);
		request.setAttribute("classes", subjectClasses);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/subject/index.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * Display edit form for subject
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
		SubjectModel updateSubject = SubjectDao.getSubjects(id);

		List<TeacherModel> listTeacher = TeacherDao.getAllTeacher();

		RequestDispatcher dispatcher = request.getRequestDispatcher("/subject/update.jsp");
		request.setAttribute("updateSubject", updateSubject);
		request.setAttribute("listTeacher", listTeacher);
		dispatcher.forward(request, response);

	}

	/**
	 * Update data for subject
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		SubjectModel s = new SubjectModel();

		int class_id = Integer.parseInt(request.getParameter("class_id"));
		ClassesModel subjectClass = ClassesDao.getClasses(class_id);

		int teacher_id = Integer.parseInt(request.getParameter("teacher"));
		TeacherModel teacher = TeacherDao.getTeacher(teacher_id);

		s.setId(id);
		s.setSubject(request.getParameter("subjectName"));
		s.setSubjectTime(request.getParameter("subjectTime"));
		s.setClasses(subjectClass);
		s.setTeacher(teacher);

		SubjectDao.update(s);
		response.sendRedirect(request.getContextPath() + "/subject/index?class_id=" + class_id);

	}

	/**
	 * Delete subject Record from Id
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int class_id = Integer.parseInt(request.getParameter("class_id"));
		SubjectDao.deleteSubject(id);
		response.sendRedirect(request.getContextPath() + "/subject/index?class_id=" + class_id);
	}

}
