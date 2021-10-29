package com.spring.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.dao.LopHocDAO;
import com.spring.backend.model.GiaoVien;
import com.spring.backend.model.LopHoc;
import com.spring.backend.model.SinhVien;

@Service
@Transactional
public class LopHocService {

	@Autowired
	private LopHocDAO lhDAO;

	public List<LopHoc> printAllLopHocSinhVienInSemester(SinhVien sv, int namhoc, int ky) {
		return lhDAO.allClassOfStudentBySemester(sv, namhoc, ky);
	}
	
	public List<LopHoc> printAllLopHocSinhVien(SinhVien sv, int offset, int limit) {
		return lhDAO.allClassOfStudent(sv, offset, limit);
	}
	
	public List<LopHoc> printAllLopHocGiaoVienInSemester(GiaoVien gv, int namhoc, int ky) {
		return lhDAO.allClassOfTeacherBySemester(gv, namhoc, ky);
	}
	
	public List<LopHoc> printAllLopHocGiaoVien(GiaoVien gv, int offset, int limit) {
		return lhDAO.allClassOfTeacher(gv, offset, limit);
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
