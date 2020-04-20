package com.hibernate.jdbc.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.entity.Instructor;
import com.hibernate.jdbc.entity.InstructorDetail;

public class ReadDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			// start a transaction

			session.beginTransaction();

			// save the instructor

			System.out.println("Reading the tables");

//			Instructor instructor = session.get(Instructor.class, 2);
//
//			System.out.println("Full Name = " + instructor.getFirstName() + "  " + instructor.getLastName());
//			System.out.println("Email = " + instructor.getEmail());
//			System.out.println("YouTube channel = " + instructor.getInstructorDetail().getYoutubeChannel());
//			System.out.println("Hobby is = " + instructor.getInstructorDetail().getHobby());

			InstructorDetail instructor = session.get(InstructorDetail.class, 20);

			System.out.println("Full Name = " + instructor.getInstructor().getFirstName() + "  "
					+ instructor.getInstructor().getLastName());
			System.out.println("Email = " + instructor.getInstructor().getEmail());
			System.out.println("YouTube channel = " + instructor.getYoutubeChannel());
			System.out.println("Hobby is = " + instructor.getHobby());

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
