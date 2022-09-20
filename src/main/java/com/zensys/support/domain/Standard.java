package com.zensys.support.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class Standard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;	
	@Column(nullable=false)
	private String name;
	
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Standard(long id, String name, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "standard")
	private List<Course> courses;
	
	
}
