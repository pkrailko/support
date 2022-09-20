package com.zensys.support.domain;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long courseId;	
	@Column(nullable=false, unique=true)        //make name a unique field 
	private String name;
	private int duration;      					//course duration in weeks
	private String type;       					//course type academic/professional
	private String teachingMode; 				//online/classroom/hybrid
	private double fees;
	private String description;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standard")
    private Standard standard;
	
	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTeachingMode() {
		return teachingMode;
	}

	public void setTeachingMode(String teachingMode) {
		this.teachingMode = teachingMode;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}

	public Course(long courseId, String name, int duration, String type, String teachingMode, double fees, String description,
			Standard standard, Set<Student> students, Set<Faculty> faculties) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.duration = duration;
		this.type = type;
		this.teachingMode = teachingMode;
		this.fees = fees;
		this.description = description;
		this.standard = standard;
		this.students = students;
		this.faculties = faculties;
	}

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "courseId") }, inverseJoinColumns = { @JoinColumn(name = "id") } )
	private Set<Student> students = new HashSet<Student>(0); 
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "faculty_course", joinColumns = { @JoinColumn(name = "courseId") }, inverseJoinColumns = { @JoinColumn(name = "id") } )
	private Set<Faculty> faculties = new HashSet<Faculty>(0); 
	
	
}
