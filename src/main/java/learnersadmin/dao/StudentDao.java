package learnersadmin.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import learnersadmin.model.StudentModel;

public class StudentDao {

	public StudentDao() {
		super();
	}

	/**
	 * 
	 * @param t StudentModel
	 * @return
	 */
	public static int save(StudentModel t) {

		int status = 0;

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			System.out.println(t);
			session.save(t);
			transaction.commit();
			status = 1;

		} catch (Exception ex) {
			status = 2;
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(StudentModel s) {

		int status = 0;

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.update(s);
			transaction.commit();
			status = 1;

		} catch (Exception ex) {
			status = 2;
			ex.printStackTrace();
		}

		return status;
	}

	public static StudentModel getStudent(int id) {

		Transaction transaction = null;
		StudentModel student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			student = session.get(StudentModel.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}

	@SuppressWarnings("unchecked")
	public static List<StudentModel> getAllStudents(int class_id) {

		Transaction transaction = null;
		List<StudentModel> listOfStudent = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			// start a transaction
			transaction = session.beginTransaction();
			listOfStudent = session.createQuery("FROM student WHERE class_id = " + class_id).getResultList();

			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return listOfStudent;

	}

	/**
	 * Delete User
	 * 
	 * @param id
	 */
	public static void deleteStudent(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			StudentModel student = session.get(StudentModel.class, id);
			if (student != null) {
				session.delete(student);
				System.out.println("Student is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
