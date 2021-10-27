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
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.criteria.Join;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.model.LopHoc;
import com.spring.backend.common.SearchObject;
import com.spring.backend.model.SinhVien;
import com.spring.backend.model.ChiTietLopHoc;

@Repository(value = "lopHocDAO")
@Transactional(rollbackFor = Exception.class)
public class LopHocDAO {

	@PersistenceContext  
	private EntityManager entityManager;
	
	public void persist(final LopHoc gv) {
		entityManager.persist(gv);
	}
	
	public LopHoc findById(final Long id) {
	    return entityManager.find(LopHoc.class, id);
	}
	
	public void delete(final LopHoc gv) {
	    entityManager.remove(gv);
	}
	
	//Dua ra danh sach lop hoc cua sinh vien
	public List<LopHoc> allClassOfStudent(SinhVien sv) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		Metamodel m = entityManager.getMetamodel();
		EntityType<ChiTietLopHoc> ChiTietLopHoc_ = m.entity(ChiTietLopHoc.class);
	    CriteriaQuery<LopHoc> cq = cb.createQuery(LopHoc.class);
	    Root<LopHoc> lopHocRoot = cq.from(LopHoc.class);
	    Root<ChiTietLopHoc> chiTietLopHocRoot = cq.from(ChiTietLopHoc_);
	    Join<LopHoc, ChiTietLopHoc> chiTietLH = chiTietLopHocRoot.join(chiTietLopHocRoot.);
	    Predicate pre = cb.and(pre, cb.equal(chiTietLH.get(ChiTietLopHoc_.msv), sv.getMasinhvien()));

		TypedQuery<LopHoc> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
	
	//Dua ra danh sach lop hoc cua giao vien dang giang day
	public List<LopHoc> allClassOfTeacher(SearchObject search, int offset, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<LopHoc> cq = cb.createQuery(LopHoc.class);
	    Root<LopHoc> giaoVienRoot = cq.from(LopHoc.class);
	    String[] splitSearch = search.getString1().split(" ");
	    List<Predicate> predicates = new ArrayList<>();
	    if(splitSearch.length > 0) {
	    	for (String i : splitSearch) {
	    		Predicate p1 = cb.like(giaoVienRoot.get("name"), i);
	    		if (p1 != null) {
	    			predicates.add(p1);
	    		}
	    	}
	    }
		cq.where(predicates.toArray(new Predicate[splitSearch.length]));
		TypedQuery<LopHoc> query = entityManager.createQuery(cq);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}
}
