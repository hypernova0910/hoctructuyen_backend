package com.spring.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.service.model.ClassInfo;

@Repository
public interface ClassInfoRepo extends JpaRepository<ClassInfo, Long> {
	
}
