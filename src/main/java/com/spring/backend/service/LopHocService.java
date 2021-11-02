package com.spring.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.common.SearchObject;
import com.spring.backend.dao.LopHocDAO;
import com.spring.backend.model.LopHoc;

@Service
@Transactional
public class LopHocService {

	@Autowired
	private LopHocDAO lhDAO;

	public List<LopHoc> studentClassInSemesterService(SearchObject search, int namhoc, int ky) {
		return lhDAO.studentClassInSemester(search, namhoc, ky);
	}
	
	public List<LopHoc> printAllStudentClassService(SearchObject search, int offset, int limit) {
		return lhDAO.allClassOfStudent(search, offset, limit);
	}
	
	public List<LopHoc> teacherClassInSemesterService(SearchObject search, int namhoc, int ky) {
		return lhDAO.teacherClassInSemester(search, namhoc, ky);
	}
	
	public List<LopHoc> printAllTeacherClassService(SearchObject search, int offset, int limit) {
		return lhDAO.allClassOfTeacher(search, offset, limit);
	}

	public LopHoc findById(final Long id) {
		return lhDAO.findById(id);
	}

	public void save(final LopHoc lh) {
		// check if exist -> throw exception
		lhDAO.persist(lh);
	}

	public void update(final LopHoc lh) {
		// check if not exist -> throw excpetion
		LopHoc newLH = lhDAO.findById(lh.getMalophoc());
		newLH.setKy(lh.getKy());
		newLH.setNamHoc(lh.getNamHoc());
		newLH.setTenLopHoc(lh.getTenLopHoc());
		newLH.setNgayHoc(lh.getNgayHoc());
		newLH.setThoiGianBatDau(lh.getThoiGianBatDau());
		newLH.setThoiGianKetThuc(lh.getThoiGianKetThuc());
		newLH.setLink(lh.getLink());
		newLH.setMoTa(lh.getMoTa());
		lhDAO.persist(newLH);
	}

	public void delete(final Long id) {
		LopHoc lh = lhDAO.findById(id);
		if (lh != null) {
			lhDAO.delete(lh);
		}
	}
}
