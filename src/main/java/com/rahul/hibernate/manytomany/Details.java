package com.rahul.hibernate.manytomany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "details")
public class Details {

	private long details_id;
	private int age;
	private String city;
	private Set<Person> person;

	public Details() {
		person = new HashSet<Person>();
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

	@ManyToMany
	@JoinTable(name = "person_details", joinColumns = @JoinColumn(name = "details_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
	public Set<Person> getPerson() {
		return person;
	}

	public void setPerson(Set<Person> person) {
		this.person = person;
	}

}
