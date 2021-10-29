package com.spring.backend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Join;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.model.LopHoc;
import com.spring.backend.model.SinhVien;
import com.spring.backend.model.GiaoVien;
import com.spring.backend.model.ChiTietLopHoc;

@Repository(value = "lopHocDAO")
@Transactional(rollbackFor = Exception.class)
public class LopHocDAO {

	@PersistenceContext  
	private EntityManager entityManager;
	
	public void persist(final LopHoc lh) {
		entityManager.persist(lh);
	}
	
	public LopHoc findById(final Long id) {
	    return entityManager.find(LopHoc.class, id);
	}
	
	public void delete(final LopHoc lh) {
	    entityManager.remove(lh);
	}
	
	//Dua ra danh sach lop hoc cua sinh vien theo nam hoc va ky
	public List<LopHoc> allClassOfStudentBySemester(SinhVien sv, int namhoc, int ky) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<LopHoc> cq = cb.createQuery(LopHoc.class);
	    Root<ChiTietLopHoc> chiTietLopHocRoot = cq.from(ChiTietLopHoc.class);
	    Root<LopHoc> lopHocRoot = cq.from(LopHoc.class);
	    Join<ChiTietLopHoc, LopHoc> lh = lopHocRoot.join("malophoc");
	    
	    List<Predicate> pre = new ArrayList<>();
	    cq.multiselect(lh.get("malophoc"), lh.get("ky"), lh.get("namhoc"), lh.get("tenLopHoc"), lh.get("ngayHoc"), lh.get("thoiGianBatDau"), lh.get("thoiGianKetThuc"), lh.get("link"), lh.get("mota"));
		pre.add(cb.equal(chiTietLopHocRoot.get("SinhVien").get("masinhvien"), sv.getMasinhvien()));
		pre.add(cb.equal(lh.get("ky"), ky));
		pre.add(cb.equal(lh.get("namhoc"), namhoc));
	    cq.where(pre.toArray(new Predicate[pre.size()]));

		TypedQuery<LopHoc> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
	
	//Dua ra toan bo lop hoc cua sinh vien
	public List<LopHoc> allClassOfStudent(SinhVien sv, int offset, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<LopHoc> cq = cb.createQuery(LopHoc.class);
	    Root<ChiTietLopHoc> chiTietLopHocRoot = cq.from(ChiTietLopHoc.class);
	    Root<LopHoc> lopHocRoot = cq.from(LopHoc.class);
	    Join<ChiTietLopHoc, LopHoc> lh = lopHocRoot.join("malophoc");
	    
	    List<Predicate> pre = new ArrayList<>();
	    cq.multiselect(lh.get("malophoc"), lh.get("ky"), lh.get("namhoc"), lh.get("tenLopHoc"), lh.get("ngayHoc"), lh.get("thoiGianBatDau"), lh.get("thoiGianKetThuc"), lh.get("link"), lh.get("mota"));
		pre.add(cb.equal(chiTietLopHocRoot.get("SinhVien").get("masinhvien"), sv.getMasinhvien()));
	    cq.where(pre.toArray(new Predicate[pre.size()]));

		TypedQuery<LopHoc> query = entityManager.createQuery(cq);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}
	
	//Dua ra danh sach lop hoc cua giao vien dang giang day theo nam hoc va ky
	public List<LopHoc> allClassOfTeacherBySemester(GiaoVien gv, int namhoc, int ky) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<LopHoc> cq = cb.createQuery(LopHoc.class);
	    Root<LopHoc> lopHocRoot = cq.from(LopHoc.class);
	    
	    List<Predicate> pre = new ArrayList<>();
		pre.add(cb.equal(lopHocRoot.get("giaovien").get("magiaovien"), gv.getMagiaovien()));
		pre.add(cb.equal(lopHocRoot.get("ky"), ky));
		pre.add(cb.equal(lopHocRoot.get("namhoc"), namhoc));
	    cq.where(pre.toArray(new Predicate[pre.size()]));

		TypedQuery<LopHoc> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
	
	//Dua ra toan bo lop giang day cua giao vien
	public List<LopHoc> allClassOfTeacher(GiaoVien gv, int offset, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<LopHoc> cq = cb.createQuery(LopHoc.class);
	    Root<LopHoc> lopHocRoot = cq.from(LopHoc.class);
	    
	    List<Predicate> pre = new ArrayList<>();
		pre.add(cb.equal(lopHocRoot.get("giaovien").get("magiaovien"), gv.getMagiaovien()));
	    cq.where(pre.toArray(new Predicate[pre.size()]));

		TypedQuery<LopHoc> query = entityManager.createQuery(cq);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}
}
