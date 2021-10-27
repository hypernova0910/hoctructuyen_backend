package com.spring.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.common.SearchObject;
import com.spring.backend.dao.SinhVienDAO;
import com.spring.backend.model.SinhVien;

@Service
@Transactional
public class SinhVienService {

	@Autowired
	private SinhVienDAO svDAO;
	
	public List<SinhVien> findAll(SearchObject search, int offset, int limit) {
		return svDAO.findAll(search, offset, limit);
	}
	
	public SinhVien findById(final Long id) {
	    return svDAO.findById(id);
	}
	
	public void save(final SinhVien classInfo) {
	    // check if exist -> throw exception
		svDAO.persist(classInfo);
	}
	public void update(final SinhVien sv) {
		// check if not exist -> throw excpetion
		SinhVien sinhVienDb = svDAO.findById(sv.getMasinhvien());
		sinhVienDb.setTenSinhVien(sv.getTenSinhVien());
		sinhVienDb.setSdt(sv.getSdt());
		sinhVienDb.setEmail(sv.getEmail());
		sinhVienDb.setPassword(sv.getPassword());
		svDAO.persist(sinhVienDb);
	}
	
	public void delete(final Long id) {
		SinhVien sv = svDAO.findById(id);
	    if (sv != null) {
	    	svDAO.delete(sv);
	    }
	}
}
