package com.spring.backend.controller;

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
import com.spring.backend.model.NhomFileSV;
import com.spring.backend.service.NhomFileSinhVienService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping(Constants.API_URL + "NhomFileSinhVien")
public class NhomFileSinhVienController {

	@Autowired
	private NhomFileSinhVienService nhomFileSinhVienService;
	
	@PostMapping("addNhomFileSinhVien")
	public void addobj(@RequestBody NhomFileSV nfsv) {
		nhomFileSinhVienService.save(nfsv);
	}
	
	//JSON truyen vao idsinhvien, idquatrinhhoc, diem
	@PostMapping("updateNhomFileSinhVien")
	public void updateObj(@RequestBody SearchObject search){
		nhomFileSinhVienService.update(search);
	}
	
	@GetMapping("getOneById/{idsinhvien}/{idquatrinhhoc}")
	public NhomFileSV getOneById(@PathVariable Long idsinhvien, @PathVariable Long idquatrinhhoc){
		return nhomFileSinhVienService.findByIdService(idsinhvien, idquatrinhhoc);
	}
}
