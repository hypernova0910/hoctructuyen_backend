package com.spring.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.common.SearchObject;
import com.spring.backend.dao.GiaoVienDAO;
import com.spring.backend.model.GiaoVien;

@Service
@Transactional
public class GiaoVienService {

	@Autowired
	private GiaoVienDAO gvDAO;
	
	public List<GiaoVien> findAll(SearchObject search, int offset, int limit) {
		return gvDAO.findAll(search, offset, limit);
	}
	
	public GiaoVien findById(final Long id) {
	    return gvDAO.findById(id);
	}
	
	public void save(final GiaoVien gv) {
	    // check if exist -> throw exception
		gvDAO.persist(gv);
	}
	public void update(final GiaoVien gv) {
		// check if not exist -> throw exception
		GiaoVien newGV = gvDAO.findById(gv.getMagiaovien());
		newGV.setTenGiaoVien(gv.getTenGiaoVien());
		newGV.setSdt(gv.getSdt());
		newGV.setEmail(gv.getEmail());
		newGV.setPassword(gv.getPassword());
		gvDAO.persist(newGV);
	}
	
	public void delete(final Long id) {
		GiaoVien gv = gvDAO.findById(id);
	    if (gv != null) {
	    	gvDAO.delete(gv);
	    }
	}
}
