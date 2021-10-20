package com.spring.service.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.service.common.SearchObject;
import com.spring.service.model.ClassInfo;

@Repository(value = "classInfoDAO")
@Transactional(rollbackFor = Exception.class)
public class ClassInfoDAO {
	@PersistenceContext  
	private EntityManager entityManager;
	
	public void persist(final ClassInfo classInfo) {
		entityManager.persist(classInfo);
	}
	
	public ClassInfo findById(final Long id) {
	    return entityManager.find(ClassInfo.class, id);
	}
	
	public void delete(final ClassInfo classInfo) {
	    entityManager.remove(classInfo);
	}
	
	public List<ClassInfo> findAll(SearchObject search, int offset, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<ClassInfo> cq = cb.createQuery(ClassInfo.class);
	    Root<ClassInfo> classInfoRoot = cq.from(ClassInfo.class);
	    List<Predicate> predicates = new ArrayList<>();
	    if(search.getLong1() != null && search.getLong1() > 0) {
	    	predicates.add(cb.equal(classInfoRoot.get("teacher").get("id"), search.getLong1()));
	    }
		cq.where(predicates.toArray(new Predicate[0]));
//		List<Order> orders = new ArrayList<>();
//		orders.add(cb.asc(classInfoRoot.get("title")));
//		cq.orderBy(orders);
		TypedQuery<ClassInfo> query = entityManager.createQuery(cq);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return query.getResultList();
	}
}
