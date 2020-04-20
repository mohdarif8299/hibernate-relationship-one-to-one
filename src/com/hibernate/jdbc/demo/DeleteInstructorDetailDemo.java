package com.hibernate.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.entity.Instructor;
import com.hibernate.jdbc.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// create the objects

			int instructorId = 1;

			// associated the objects

			// start a transaction

			session.beginTransaction();

			// save the instructor

			System.out.println("Deleting  the tables");

			InstructorDetail instructor = session.get(InstructorDetail.class, instructorId);

			session.delete(instructor);

			System.out.println("Object Deleted");
			// end transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
