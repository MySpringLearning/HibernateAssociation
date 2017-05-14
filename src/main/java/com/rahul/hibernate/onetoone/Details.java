package com.rahul.hibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "person_details")
public class Details {

	private long details_id;
	private int age;
	private String city;
	private Person person;

	public Details() {

	}

	public Details(long details_id, int age, String city) {
		super();
		this.details_id = details_id;
		this.age = age;
		this.city = city;
	}

	@Id
	@GeneratedValue
	public long getDetails_id() {
		return details_id;
	}

	public void setDetails_id(long details_id) {
		this.details_id = details_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Details [details_id=" + details_id + ", age=" + age + ", city=" + city + ", person=" + person + "]";
	}

	@OneToOne(mappedBy = "details", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
