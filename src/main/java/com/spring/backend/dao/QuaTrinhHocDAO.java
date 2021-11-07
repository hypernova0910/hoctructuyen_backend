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
import com.spring.backend.model.LopHoc;
import com.spring.backend.model.QuaTrinhHoc;
import com.spring.backend.model.QuaTrinhHoc_;

@Repository(value = "QuaTrinhHocDAO")
@Transactional(rollbackFor = Exception.class)

public class QuaTrinhHocDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(final QuaTrinhHoc qth) {
		entityManager.persist(qth);
	}

	public QuaTrinhHoc findById(final Long id) {
		return entityManager.find(QuaTrinhHoc.class, id);
	}

	public void delete(final QuaTrinhHoc qth) {
		entityManager.remove(qth);
	}

	// Dua ra toan bo qua trinh hoc cua 1 lop hoc
	public List<QuaTrinhHoc> printAllLearningProcess(SearchObject search) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<QuaTrinhHoc> cq = cb.createQuery(QuaTrinhHoc.class);
		Root<QuaTrinhHoc> quaTrinhHocRoot = cq.from(QuaTrinhHoc.class);
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(quaTrinhHocRoot.get(QuaTrinhHoc_.malophoc), search.getString1()));
		cq.where(predicates.toArray(new Predicate[0]));
		cq.orderBy(cb.asc(quaTrinhHocRoot.get("thoiGianTao")));
		TypedQuery<QuaTrinhHoc> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
}
