package com.zensys.support.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensys.support.domain.Faculty;
import com.zensys.support.domain.FacultyRepository;

@RestController
public class FacultyController {
	
	@Autowired
	private FacultyRepository repository;
	
	@RequestMapping("/faculties")
	public Iterable<Faculty> getFaculties() {
		return repository.findAll();
	}

}
