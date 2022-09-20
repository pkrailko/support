package com.zensys.support.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FacultyRepository extends CrudRepository <Faculty, Long> {
	
	// Fetch faculty by role
	List<Faculty> findByRoleOrderByNameAsc(@Param("role") String role);

	//@Query(select f from Faculty f where f.designation = ?1") 
	List<Faculty> findByDesignationOrderByNameAsc(@Param("designation") String designation);
	
	List<Faculty> findByBranch(@Param("branchName") String branchName);
	
	//List<Faculty> findByCourse(@Param("courseName") String courseName);
		
}
