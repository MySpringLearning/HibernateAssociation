package com.rahul.hibernate.onetoone;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "person")
public class Person {

	private long person_id;
	private String person_name;

	private Details details;

	public Person() {

	}

	public Person(long person_id, String person_name) {
		super();
		this.person_id = person_id;
		this.person_name = person_name;
	}

	@Id
	public long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(long person_id) {
		this.person_id = person_id;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", person_name=" + person_name +  "]";
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "details_id")
	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

}
