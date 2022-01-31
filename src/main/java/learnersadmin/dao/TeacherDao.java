package learnersadmin.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import learnersadmin.model.TeacherModel;

public class TeacherDao {

	public TeacherDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static int save(TeacherModel t) {

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

	public static int update(TeacherModel t) {

		int status = 0;

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.update(t);
			transaction.commit();
			status = 1;

		} catch (Exception ex) {
			status = 2;
			ex.printStackTrace();
		}

		return status;
	}

	public static TeacherModel getTeacher(int id) {

		Transaction transaction = null;
		TeacherModel teacher = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			teacher = session.get(TeacherModel.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return teacher;
	}

	/**
	 * Get all Teacher
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<TeacherModel> getAllTeacher() {

		Transaction transaction = null;
		List<TeacherModel> listOfTeacher = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			// start a transaction
			transaction = session.beginTransaction();
			listOfTeacher = session.createQuery("FROM teachers").getResultList();
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return listOfTeacher;

	}

	/**
	 * Delete User
	 * 
	 * @param id
	 */
	public void deleteTeacher(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			TeacherModel teacher = session.get(TeacherModel.class, id);
			if (teacher != null) {
				session.delete(teacher);
				System.out.println("Teacher is deleted");
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
