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
import com.spring.backend.model.GiaoVien;
import com.spring.backend.service.GiaoVienService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping(Constants.API_URL + "giaovien")

public class GiaoVienController {

	@Autowired
	private GiaoVienService gvService;
	
	@PostMapping("getAll/{offset}/{limit}")
	public List<GiaoVien> getAll(@RequestBody SearchObject search, @PathVariable int offset, @PathVariable int limit){
		return gvService.findAll(search, offset, limit);
	}
	
	@GetMapping("getOneById/{id}")
	public GiaoVien getOneById(@PathVariable Long id){
		return gvService.findById(id);
	}
	
	@PostMapping("addGiaoVien")
	public void addObj(@RequestBody GiaoVien gv){
		gvService.save(gv);
	}
	
	@PostMapping("updateGiaoVien")
	public void updateObj(@RequestBody GiaoVien gv){
		gvService.update(gv);
	}
	
	@PostMapping("deleteGiaoVien")
	public void deleteObj(@RequestBody Long id){
		gvService.delete(id);
	}
}
