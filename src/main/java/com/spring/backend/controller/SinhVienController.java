package com.spring.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backend.common.Constants;
import com.spring.backend.common.SearchObject;
import com.spring.backend.model.SinhVien;
import com.spring.backend.service.SinhVienService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping(Constants.API_URL + "sinhvien")

public class SinhVienController {

	@Autowired
	private SinhVienService svService;
	
	@PostMapping("getAll/{offset}/{limit}")
	public List<SinhVien> getAll(@RequestBody SearchObject search, @PathVariable int offset, @PathVariable int limit){
		return svService.findAll(search, offset, limit);
	}
	
	@GetMapping("getOneById/{id}")
	public SinhVien getOneById(@PathVariable Long id){
		return svService.findById(id);
	}
	
	@PostMapping("addSinhVien")
	public void addObj(@RequestBody SinhVien sv){
		svService.save(sv);
	}
	
	@PostMapping("updateSinhVien")
	public void updateObj(@RequestBody SinhVien sv){
		svService.update(sv);
	}
	
	@PostMapping("deleteSinhVien")
	public void deleteObj(@RequestBody Long id){
		svService.delete(id);
	}
}
