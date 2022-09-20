package com.zensys.support.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProgressReport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private Date onDate;            // Auto filled only initially 
	private String grade;           //Excellent/Good/Normal/Poor
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOnDate() {
		return onDate;
	}

	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ProgressReport(long id, Date onDate, String grade, float percentage, String remarks, Student student) {
		super();
		this.id = id;
		this.onDate = onDate;
		this.grade = grade;
		this.percentage = percentage;
		this.remarks = remarks;
		this.student = student;
	}

	private float percentage;
    private String remarks;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student")
    private Student student;
    
        
}
