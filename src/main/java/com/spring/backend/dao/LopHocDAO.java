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
import javax.persistence.criteria.ListJoin;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.model.LopHoc;
import com.spring.backend.model.LopHoc_;
import com.spring.backend.common.SearchObject;
import com.spring.backend.model.ChiTietLopHoc;
import com.spring.backend.model.ChiTietLopHoc_;
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
	public List<LopHoc> studentClassInSemester(SearchObject search, int namhoc, int ky) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<LopHoc> cq = cb.createQuery(LopHoc.class);
	    Root<LopHoc> lopHocRoot = cq.from(LopHoc.class);
	    
	    ListJoin<LopHoc, ChiTietLopHoc> lh = lopHocRoot.join(LopHoc_.chiTietLopHocs);
	    
	    List<Predicate> pre = new ArrayList<>();
	    pre.add(cb.equal(lh.get(ChiTietLopHoc_.sinhVien), search.getLong1()));
	    if(ky > 0) {
	    	pre.add(cb.equal(lopHocRoot.get(LopHoc_.ky), ky));
	    }
		if(namhoc > 0) {
			pre.add(cb.equal(lopHocRoot.get(LopHoc_.namHoc), namhoc));
		}
		
	    cq.select(lopHocRoot).where(pre.toArray(new Predicate[pre.size()]));
		if (search.getLong2() == 1) {
			cq.orderBy(cb.asc(lopHocRoot.get(LopHoc_.ngayHoc)), cb.asc(lopHocRoot.get(LopHoc_.thoiGianBatDau)));
		}
		else {
			cq.orderBy(cb.asc(lopHocRoot.get(LopHoc_.tenLopHoc)));
		}
	    
		TypedQuery<LopHoc> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
	
	//Dua ra toan bo lop hoc cua sinh vien
	public List<LopHoc> allClassOfStudent(SearchObject search, int offset, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<LopHoc> cq = cb.createQuery(LopHoc.class);
	    Root<LopHoc> lopHocRoot = cq.from(LopHoc.class);
	    
	    ListJoin<LopHoc, ChiTietLopHoc> lh = lopHocRoot.join(LopHoc_.chiTietLopHocs);
	    
	    List<Predicate> pre = new ArrayList<>();
	    pre.add(cb.equal(lh.get(ChiTietLopHoc_.sinhVien), search.getLong1()));
	    cq.select(lopHocRoot).where(pre.toArray(new Predicate[pre.size()]));
		if (search.getLong2() == 1) {
			cq.orderBy(cb.asc(lopHocRoot.get(LopHoc_.ngayHoc)), cb.asc(lopHocRoot.get(LopHoc_.thoiGianBatDau)));
		}
		else {
			cq.orderBy(cb.asc(lopHocRoot.get(LopHoc_.tenLopHoc)));
		}
	    
		TypedQuery<LopHoc> query = entityManager.createQuery(cq);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}
	
	//Dua ra danh sach lop hoc cua giao vien dang giang day theo nam hoc va ky
	public List<LopHoc> teacherClassInSemester(SearchObject search, int namhoc, int ky) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<LopHoc> cq = cb.createQuery(LopHoc.class);
	    Root<LopHoc> lopHocRoot = cq.from(LopHoc.class);
	    
	    List<Predicate> pre = new ArrayList<>();
		pre.add(cb.equal(lopHocRoot.get(LopHoc_.giaoVien), search.getLong1()));
		if(ky > 0) {
	    	pre.add(cb.equal(lopHocRoot.get(LopHoc_.ky), ky));
	    }
		if(namhoc > 0) {
			pre.add(cb.equal(lopHocRoot.get(LopHoc_.namHoc), namhoc));
		}
	    cq.where(pre.toArray(new Predicate[pre.size()]));
		if (search.getLong2() == 1) {
			cq.orderBy(cb.asc(lopHocRoot.get(LopHoc_.ngayHoc)), cb.asc(lopHocRoot.get(LopHoc_.thoiGianBatDau)));
		}
		else {
			cq.orderBy(cb.asc(lopHocRoot.get(LopHoc_.tenLopHoc)));
		}

		TypedQuery<LopHoc> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
	
	//Dua ra toan bo lop giang day cua giao vien
	public List<LopHoc> allClassOfTeacher(SearchObject search, int offset, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<LopHoc> cq = cb.createQuery(LopHoc.class);
	    Root<LopHoc> lopHocRoot = cq.from(LopHoc.class);
	    
	    List<Predicate> pre = new ArrayList<>();
		pre.add(cb.equal(lopHocRoot.get(LopHoc_.giaoVien), search.getLong1()));
	    cq.where(pre.toArray(new Predicate[pre.size()]));
//		if (search.getLong2() == 1) {
//			cq.orderBy(cb.asc(lopHocRoot.get(LopHoc_.ngayHoc)), cb.asc(lopHocRoot.get(LopHoc_.thoiGianBatDau)));
//		}
//		else {
//			cq.orderBy(cb.asc(lopHocRoot.get(LopHoc_.tenLopHoc)));
//		}

		TypedQuery<LopHoc> query = entityManager.createQuery(cq);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}
}
