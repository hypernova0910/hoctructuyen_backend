package com.spring.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backend.common.Constants;
import com.spring.backend.common.SearchObject;
import com.spring.backend.model.GiaoVien;
import com.spring.backend.model.SinhVien;
import com.spring.backend.service.LoginService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping(Constants.API_URL + "login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("giaovien")
	public GiaoVien loginAccountTeacher(@RequestBody SearchObject search) {
		return loginService.loginTeacher(search);
	}
	
	@PostMapping("sinhvien")
	public SinhVien loginAccountStudent(@RequestBody SearchObject search) {
		return loginService.loginStudent(search);
	}
}
