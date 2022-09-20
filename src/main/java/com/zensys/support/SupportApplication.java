package com.zensys.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zensys.support.domain.Student;
import com.zensys.support.domain.StudentRepository;
import com.zensys.support.domain.Faculty;
import com.zensys.support.domain.FacultyRepository;
import com.zensys.support.domain.User;
import com.zensys.support.domain.UserRepository;

@SpringBootApplication
public class SupportApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(SupportApplication.class);
	
	@Autowired	
	private StudentRepository srepository;

	@Autowired	
	private FacultyRepository frepository;

	@Autowired	
	private UserRepository urepository;	


	public static void main(String[] args) {
		//After adding this statement, application has restarted
		SpringApplication.run(SupportApplication.class, args);
		//logger.info("Support application has been started");
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			
			/*
			Owner owner1 = new Owner("John" , "Johnson");
			Owner owner2 = new Owner("Mary" , "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);
			
			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
			*/
			
			urepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
			urepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
		};
	}	

}
