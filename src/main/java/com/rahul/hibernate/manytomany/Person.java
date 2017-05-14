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

@Entity(name = "person")
public class Person {

	private long person_id;
	private String person_name;

	private Set<Details> details;

	public Person() {
		details = new HashSet<Details>();
	}

	public Person(long person_id, String person_name) {
		super();
		this.person_id = person_id;
		this.person_name = person_name;
	}

	@Id @GeneratedValue
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

	@ManyToMany
	@JoinTable(name = "person_details", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "details_id"))
	public Set<Details> getDetails() {
		return details;
	}

	public void setDetails(Set<Details> details) {
		this.details = details;
	}

}
