package com.hibernate.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.entity.Instructor;
import com.hibernate.jdbc.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// create the objects

			Instructor instructor = new Instructor("Mohd", "Arif", "mohdarif8299@gmail.com");

			InstructorDetail instructorDetail = new InstructorDetail("youtube.programming4fun.com", "Programming");

			instructorDetail.setInstructor(instructor);
			// associated the objects

			// start a transaction

			session.beginTransaction();

			// save the instructor

			System.out.println("Saving the tables");

			session.save(instructorDetail);

			// end transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
