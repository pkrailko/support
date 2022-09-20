package com.zensys.support.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends CrudRepository <Student, Long> {
	
	// Fetch students by status
	List<Student> findByStatusOrderByNameAsc(@Param("status") String status);
	
	List<Student> findByBranch(@Param("branchName") String branchName);

	//@Query(select s from Student s where s.course.name = ?1") 
	//List<Student> findByCourse(@Param("courseName") String courseName);
		
}
