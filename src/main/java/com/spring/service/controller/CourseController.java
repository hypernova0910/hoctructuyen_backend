package com.spring.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.common.Constants;
import com.spring.service.model.Course;
import com.spring.service.repo.CourseRepo;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping(Constants.API_URL + "course")
public class CourseController {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@GetMapping("getAll")
	public List<Course> getAll(){
		return courseRepo.findAll();
	}
	
	@GetMapping("getOneById/{id}")
	public Optional<Course> getOneById(@PathVariable Long id){
		return courseRepo.findById(id);
	}
}
