package com.zensys.support.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String name;
	private String fatherName;
	private String motherName;
	private Date doj;         					//Date of joining
	//@Column(nullable=false, unique=true)
	private String mobileNo;
	private String email;
	private String status;
	private String faceImageURL;
	private String otherDetails;

	@ManyToMany(mappedBy = "students")
	private Set<Course> courses; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch")
	private Branch branch;
	
	@OneToOne
	@JoinColumn(name = "address")
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	@JsonIgnore
	private List<ProgressReport> progressReports;


	public Student(long id, String name, String fatherName, String motherName, Date doj, String mobileNo, String email,
			String status, String faceImageURL, String otherDetails, Set<Course> courses, Branch branch,
			Address address, List<ProgressReport> progressReports) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.doj = doj;
		this.mobileNo = mobileNo;
		this.email = email;
		this.status = status;
		this.faceImageURL = faceImageURL;
		this.otherDetails = otherDetails;
		this.courses = courses;
		this.branch = branch;
		this.address = address;
		this.progressReports = progressReports;
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

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFaceImageURL() {
		return faceImageURL;
	}

	public void setFaceImageURL(String faceImageURL) {
		this.faceImageURL = faceImageURL;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<ProgressReport> getProgressReports() {
		return progressReports;
	}

	public void setProgressReports(List<ProgressReport> progressReports) {
		this.progressReports = progressReports;
	}
			
}
