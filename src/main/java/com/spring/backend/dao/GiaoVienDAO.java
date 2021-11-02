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

import com.spring.backend.model.GiaoVien;
import com.spring.backend.common.SearchObject;

@Repository(value = "giaoVienDAO")
@Transactional(rollbackFor = Exception.class)

public class GiaoVienDAO {

	@PersistenceContext  
	private EntityManager entityManager;
	
	public void persist(final GiaoVien gv) {
		entityManager.persist(gv);
	}
	
	public GiaoVien findById(final Long id) {
	    return entityManager.find(GiaoVien.class, id);
	}
	
	public void delete(final GiaoVien gv) {
	    entityManager.remove(gv);
	}
	
	//Dua ra danh sach giao vien duoc tim kiem theo ten
	public List<GiaoVien> findAll(SearchObject search, int offset, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<GiaoVien> cq = cb.createQuery(GiaoVien.class);
		Root<GiaoVien> gvRoot = cq.from(GiaoVien.class);
		if (search.getString1() != "") {
			String[] splitSearch = search.getString1().split(" ");
			List<Predicate> predicates = new ArrayList<>();
			if (splitSearch.length > 0) {
				for (String i : splitSearch) {
					Predicate p1 = cb.like(gvRoot.get("tenGiaoVien"), "%"+i+"%");
					predicates.add(p1);
				}
			}
			Predicate p2 = cb.or(predicates.toArray(new Predicate[predicates.size()]));
			cq.where(p2);
			TypedQuery<GiaoVien> query = entityManager.createQuery(cq);
			query.setFirstResult(offset);
			query.setMaxResults(limit);
			return query.getResultList();
		}
		else {
			return null;
		}
	}
}
