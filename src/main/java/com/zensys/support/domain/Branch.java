package com.zensys.support.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(nullable=false, unique=true)				//make name a unique field
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "branch")
	@JsonIgnore
	private List<Faculty> faculties;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "branch")
	@JsonIgnore
	private List<Student> students;

	@OneToOne
	@JoinColumn(name = "address")
	private Address address;
	
	public Branch(long id, String name, Address address, List<Faculty> faculties, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.faculties = faculties;
		this.students = students;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Faculty> getFaculties() {
		return faculties;
	}
	
	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
