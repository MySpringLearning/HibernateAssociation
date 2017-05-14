package com.rahul.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Driver {

	public static void main(String[] str) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate-manytomany.cfg.xml")
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Person person = new Person();
		person.setPerson_name("Rahul");

		Details details = new Details();
		details.setAge(30);
		details.setCity("Hyderabad");
		Details details1 = new Details();
		details1.setAge(31);
		details1.setCity("Srikakulam");

		person.getDetails().add(details);
		person.getDetails().add(details1);

		details.getPerson().add(person);
		details1.getPerson().add(person);

		session.save(details);
		session.save(details1);
		session.save(person);

		session.getTransaction().commit();

		// session = sessionFactory.openSession();
		// session.beginTransaction();
		//
		// Person p = session.get(Person.class, 0l);
		// System.out.println(p);
		//
		// Details d = session.get(Details.class, 1l);
		// System.out.println(d);
		//
		// session.close();

	}

}
