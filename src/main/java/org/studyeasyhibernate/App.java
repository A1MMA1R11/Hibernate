package org.studyeasyhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasyhibernate.entity.Users;

public class App {

	public static void main(String[] args) {
		Configuration configuration = new Configuration()
                					  .configure("hibernate.cfg.xml") // Load hibernate.cfg.xml
                					  .addAnnotatedClass(Users.class);
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// Create object of entity class type
			Users users = new Users("username", "passsword", "first_name" , "last_name");
			
			// Start transaction
			session.beginTransaction();
			
			// Perform operation
			session.save(users);
			
			// Commit the transaction
			session.getTransaction().commit();
			System.out.println("Row Added");
			
		}finally {
			session.close(); //SharedSessionContract
			factory.close();			
		}
	}

}
