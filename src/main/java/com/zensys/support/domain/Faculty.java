package com.zensys.support.domain;

import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Entity
public class Faculty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String name;
	private String designation;
	private String role;                            // Teacher/Manager/Employee
	private Date doj;         						// Date of joining
	//@Column(nullable=false)
	private String mobileNo;
	private String email;
	private String faceImageURL;
	private String otherDetails;
	
	@ManyToMany(mappedBy = "faculties")
	private Set<Course> courses; 
	
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public Faculty(long id, String name, String designation, String role, Date doj, String mobileNo, String email,
			String faceImageURL, String otherDetails, Set<Course> courses, Branch branch, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.role = role;
		this.doj = doj;
		this.mobileNo = mobileNo;
		this.email = email;
		this.faceImageURL = faceImageURL;
		this.otherDetails = otherDetails;
		this.courses = courses;
		this.branch = branch;
		this.address = address;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch")
	private Branch branch;

	@OneToOne
	@JoinColumn(name = "address")
	private Address address;
			

}
