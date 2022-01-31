package learnersadmin.dao;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import learnersadmin.model.TeacherModel;
import learnersadmin.model.ClassesModel;
import learnersadmin.model.SubjectModel;
import learnersadmin.model.StudentModel;


public class HibernateUtil {
	 private static SessionFactory sessionFactory;

	 /**
	  * 
	  * @return
	  */
	 public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
	   try {
	    Configuration configuration = new Configuration();

	    // Hibernate settings equivalent to hibernate.cfg.xml's properties
	    Properties settings = new Properties();
	    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/project1?useSSL=false");
	    settings.put(Environment.USER, "root");
	    settings.put(Environment.PASS, "root");
	    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

	    settings.put(Environment.SHOW_SQL, "true");

	    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	    settings.put(Environment.HBM2DDL_AUTO, "update");

	    configuration.setProperties(settings);
	    configuration.addAnnotatedClass(TeacherModel.class);
	    configuration.addAnnotatedClass(ClassesModel.class);
	    configuration.addAnnotatedClass(SubjectModel.class);
	    configuration.addAnnotatedClass(StudentModel.class);

	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	      .applySettings(configuration.getProperties()).build();
	    System.out.println("Hibernate Java Config serviceRegistry created");
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return sessionFactory;
	 }
	}