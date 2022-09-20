package com.zensys.support.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensys.support.domain.Student;
import com.zensys.support.domain.StudentRepository;


@RestController
public class StudentController {
	@Autowired
	private StudentRepository repository;
	
	@RequestMapping("/students")
	public Iterable<Student> getStudents() {
		return repository.findAll();
	}

}
