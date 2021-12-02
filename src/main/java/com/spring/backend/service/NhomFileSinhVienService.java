package com.spring.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.common.SearchObject;
import com.spring.backend.dao.NhomFileSinhVienDAO;
import com.spring.backend.model.NhomFileSV;

@Service
@Transactional
public class NhomFileSinhVienService {

	@Autowired
	NhomFileSinhVienDAO nhomFileSinhVienDAO;
	
	public Long save(final NhomFileSV nfsv) {
		nfsv.setLanSuaCuoi();
		Long id = nhomFileSinhVienDAO.persist(nfsv);
		return id;
	}
	
	public void update(SearchObject search) {
		NhomFileSV newNFSV = nhomFileSinhVienDAO.findById(search.getLong1(), search.getLong2());
		newNFSV.setDiem(search.getDouble1());
//		newNFSV.setLanSuaCuoi();
		nhomFileSinhVienDAO.persist(newNFSV);
	}
	
	public NhomFileSV findByIdService(final Long idsinhvien, final Long idquatrinhhoc) {
		return nhomFileSinhVienDAO.findById(idsinhvien, idquatrinhhoc);
	}
}
