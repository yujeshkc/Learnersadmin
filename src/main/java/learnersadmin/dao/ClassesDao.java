package learnersadmin.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import learnersadmin.model.ClassesModel;

public class ClassesDao {

	public ClassesDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param t ClassesModel hibernate pojo entity class
	 * @return Return 1 if update is sucess or 2 for error.
	 */
	public static int save(ClassesModel t) {

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

	/**
	 * Update class row
	 * 
	 * @param t ClassesModel hibernate pojo entity class
	 * @return Return 1 if update is sucess or 2 for error.
	 */
	public static int update(ClassesModel t) {

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

	/**
	 * Get single class data to from id
	 * 
	 * @param id class id from Mysql
	 * @return Classes row from Mysql
	 */
	public static ClassesModel getClasses(int id) {

		Transaction transaction = null;
		ClassesModel classes = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			classes = session.get(ClassesModel.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return classes;
	}

	/**
	 * Get all Classes
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<ClassesModel> getAllClasses() {

		Transaction transaction = null;
		List<ClassesModel> listOfClasses = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			// start a transaction
			transaction = session.beginTransaction();
			listOfClasses = session.createQuery("FROM classes").getResultList();
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return listOfClasses;

	}

	/**
	 * Delete Class
	 * 
	 * @param id
	 */
	public void deleteClasses(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			ClassesModel classes = session.get(ClassesModel.class, id);
			if (classes != null) {
				session.delete(classes);
				System.out.println("Classes is deleted");
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
