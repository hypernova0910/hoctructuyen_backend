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
import com.spring.backend.model.LopHoc;
import com.spring.backend.model.QuaTrinhHoc;
import com.spring.backend.service.QuaTrinhHocService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping(Constants.API_URL + "quatrinhhoc")

public class QuaTrinhHocController {

	@Autowired
	private QuaTrinhHocService qthService;
	
	@PostMapping("getAll")
	public List<QuaTrinhHoc> getAll(@RequestBody SearchObject search){
		return qthService.printAllLearningProcess(search);
	}
	
	@GetMapping("getOneById/{id}")
	public QuaTrinhHoc getOneById(@PathVariable Long id){
		return qthService.findById(id);
	}
	
	@PostMapping("addQuaTrinhHoc")
	public void addObj(@RequestBody QuaTrinhHoc qth){
		qthService.save(qth);
	}
	
	@PostMapping("updateQuaTrinhHoc")
	public void updateObj(@RequestBody QuaTrinhHoc qth){
		qthService.update(qth);
	}
	
	@PostMapping("deleteQuaTrinhHoc")
	public void deleteObj(@RequestBody Long id){
		qthService.delete(id);
	}
}
