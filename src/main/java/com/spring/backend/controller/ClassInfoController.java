//package com.spring.backend.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.spring.backend.common.Constants;
//import com.spring.backend.common.SearchObject;
//import com.spring.backend.model.ClassInfo;
//import com.spring.backend.service.ClassInfoService;
//
//@CrossOrigin(Constants.CROSS_ORIGIN)
//@RestController
//@RequestMapping(Constants.API_URL + "classInfo")
//public class ClassInfoController {
//	
//	@Autowired
//	private ClassInfoService classInfoService;
//	
//	@PostMapping("getAll/{offset}/{limit}")
//	public List<ClassInfo> getAll(@RequestBody SearchObject search, @PathVariable int offset, @PathVariable int limit){
//		return classInfoService.findAll(search, offset, limit);
//	}
//	
//	@GetMapping("getOneById/{id}")
//	public ClassInfo getOneById(@PathVariable Long id){
//		return classInfoService.findById(id);
//	}
//	
//	@PostMapping("addObj")
//	public void addObj(@RequestBody ClassInfo classInfo){
//		classInfoService.save(classInfo);
//	}
//	
//	@PostMapping("updateObj")
//	public void updateObj(@RequestBody ClassInfo classInfo){
//		classInfoService.update(classInfo);
//	}
//	
//	@PostMapping("deleteObj")
//	public void deleteObj(@RequestBody Long id){
//		classInfoService.delete(id);
//	}
//}
