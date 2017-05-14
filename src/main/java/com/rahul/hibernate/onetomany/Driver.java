package com.rahul.hibernate.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Driver {
	
	public static void main(String[] str){
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate-onetomany.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Person person = new Person();
		person.setPerson_name("Rahul");
		
		Details details = new Details();
		details.setAge(30);
		details.setCity("Hyderabad");
		details.setPerson(person);
		Details details1 = new Details();
		details1.setAge(31);
		details1.setCity("Srikakulam");
		details1.setPerson(person);
		
		List<Details> list = new ArrayList<Details>();
		list.add(details);
		list.add(details1);
		
		person.setDetails(list);
		
		session.save(person);
		
		session.getTransaction().commit();
		
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		Person p = session.get(Person.class, 0l);
//		System.out.println(p);
//		
//		Details d = session.get(Details.class, 1l);
//		System.out.println(d);
//		
//		session.close();
		
	}

}
