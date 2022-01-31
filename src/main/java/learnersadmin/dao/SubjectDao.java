package learnersadmin.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import learnersadmin.model.SubjectModel;



public class SubjectDao {	

	
	
	 
	public SubjectDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public static int save(SubjectModel t) {
		
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
	
	public static int update(SubjectModel t) {
			
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

    public static SubjectModel getSubjects(int id) {

        Transaction transaction = null;
        SubjectModel subject = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            subject = session.get(SubjectModel.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return subject;
    }
	
    /**
     * Get all Users
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<SubjectModel> getAllSubjects(int class_id) {

        Transaction transaction = null;
        List<SubjectModel> listOfSubjects = null;        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
        	
            // start a transaction
            transaction = session.beginTransaction();
            listOfSubjects = session.createQuery("FROM subjects WHERE class_id = " + class_id).getResultList();
            transaction.commit();
            
        } catch (Exception e) {
                transaction.rollback();
            e.printStackTrace();
        }
        
        return listOfSubjects;
        
        
    }
    
    /**
     * Delete User
     * @param id
     */
    public static void deleteSubject(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            SubjectModel subject = session.get(SubjectModel.class, id);
            if (subject != null) {
                session.delete(subject);
                System.out.println("Subject is deleted");
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
