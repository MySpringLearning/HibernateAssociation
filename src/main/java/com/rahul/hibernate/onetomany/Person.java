package com.rahul.hibernate.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "person")
public class Person {

	private long person_id;
	private String person_name;

	private List<Details> details;

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
		return "Person [person_id=" + person_id + ", person_name="
				+ person_name /* + ", details=" + details */ + "]";
	}

	@OneToMany(targetEntity = Details.class, mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Details> getDetails() {
		return details;
	}

	public void setDetails(List<Details> details) {
		this.details = details;
	}

}
