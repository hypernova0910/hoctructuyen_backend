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

import com.spring.backend.common.SearchObject;
import com.spring.backend.model.GiaoVien;
import com.spring.backend.model.GiaoVien_;
import com.spring.backend.model.SinhVien;
import com.spring.backend.model.SinhVien_;

@Repository(value = "loginDAO")
@Transactional(rollbackFor = Exception.class)
public class LoginDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public GiaoVien accountTeacher(SearchObject search) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<GiaoVien> cq = cb.createQuery(GiaoVien.class);
		Root<GiaoVien> giaoVienRoot = cq.from(GiaoVien.class);
		cq.select(giaoVienRoot);
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(giaoVienRoot.get(GiaoVien_.email), search.getString1()));
		predicates.add(cb.equal(giaoVienRoot.get(GiaoVien_.password), search.getString2()));
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<GiaoVien> query = entityManager.createQuery(cq);
		return query.getResultList().stream().findFirst().orElse(null);
	}
	
	public SinhVien accountStudent(SearchObject search) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SinhVien> cq = cb.createQuery(SinhVien.class);
		Root<SinhVien> sinhVienRoot = cq.from(SinhVien.class);
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(sinhVienRoot.get(SinhVien_.email), search.getString1()));
		predicates.add(cb.equal(sinhVienRoot.get(SinhVien_.password), search.getString2()));
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<SinhVien> query = entityManager.createQuery(cq);
		return query.getResultList().stream().findFirst().orElse(null);
	}
}
