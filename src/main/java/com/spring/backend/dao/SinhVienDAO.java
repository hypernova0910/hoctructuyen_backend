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

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.model.SinhVien;
import com.spring.backend.common.SearchObject;

@Repository(value = "sinhVienDAO")
@Transactional(rollbackFor = Exception.class)
public class SinhVienDAO {

	@PersistenceContext  
	private EntityManager entityManager;
	
	public void persist(final SinhVien sv) {
		entityManager.persist(sv);
	}
	
	public SinhVien findById(final Long id) {
	    return entityManager.find(SinhVien.class, id);
	}
	
	public void delete(final SinhVien sv) {
	    entityManager.remove(sv);
	}
	
	//Dua ra danh sach sinh vien duoc tim kiem theo ten
	public List<SinhVien> findAll(SearchObject search, int offset, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<SinhVien> cq = cb.createQuery(SinhVien.class);
	    Root<SinhVien> svRoot = cq.from(SinhVien.class);
	    String[] splitSearch = search.getString1().split(" ");
	    List<Predicate> predicates = new ArrayList<>();
	    if(splitSearch.length > 0) {
	    	for (String i : splitSearch) {
	    		Predicate p1 = cb.like(svRoot.get("name"), i);
	    		if (p1 != null) {
	    			predicates.add(p1);
	    		}
	    	}
	    }
		cq.where(predicates.toArray(new Predicate[splitSearch.length]));
		TypedQuery<SinhVien> query = entityManager.createQuery(cq);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}
}
