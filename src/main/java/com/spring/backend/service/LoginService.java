package com.spring.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.common.SearchObject;
import com.spring.backend.dao.LoginDAO;
import com.spring.backend.model.GiaoVien;
import com.spring.backend.model.SinhVien;

@Service
@Transactional
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;
	
	public GiaoVien loginTeacher(SearchObject search) {
		return loginDAO.accountTeacher(search);
	}
	
	public SinhVien loginStudent(SearchObject search) {
		return loginDAO.accountStudent(search);
	}
}
