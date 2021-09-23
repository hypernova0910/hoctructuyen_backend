package com.spring.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.service.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
	
}
