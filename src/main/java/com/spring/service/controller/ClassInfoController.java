package com.spring.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.common.Constants;
import com.spring.service.common.SearchObject;
import com.spring.service.model.ClassInfo;
import com.spring.service.repo.ClassInfoRepo;
import com.spring.service.service.ClassInfoService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping(Constants.API_URL + "classInfo")
public class ClassInfoController {
	
	@Autowired
	private ClassInfoService classInfoService;
	
//	@PersistenceContext  
//	private EntityManager em;
	
	@PostMapping("getAll/{offset}/{limit}")
	public List<ClassInfo> getAll(@RequestBody SearchObject search, @PathVariable int offset, @PathVariable int limit){
		return classInfoService.findAll(search, offset, limit);
	}
	
	@GetMapping("getOneById/{id}")
	public ClassInfo getOneById(@PathVariable Long id){
		return classInfoService.findById(id);
	}
	
	@PostMapping("addObj")
	public void addObj(@RequestBody ClassInfo classInfo){
		classInfoService.save(classInfo);
	}
	
	@PostMapping("updateObj")
	public void updateObj(@RequestBody ClassInfo classInfo){
		classInfoService.update(classInfo);
	}
	
	@PostMapping("deleteObj")
	public void deleteObj(@RequestBody Long id){
		classInfoService.delete(id);
	}
}
