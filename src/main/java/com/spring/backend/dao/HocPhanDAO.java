package com.spring.backend.dao;

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

import com.spring.backend.model.HocPhan;
import com.spring.backend.common.SearchObject;

@Repository(value = "hocPhanDAO")
@Transactional(rollbackFor = Exception.class)

public class HocPhanDAO {

	@PersistenceContext  
	private EntityManager entityManager;
	
	public void persist(final HocPhan hocPhan) {
		entityManager.persist(hocPhan);
	}
	
	public HocPhan findById(final Long id) {
	    return entityManager.find(HocPhan.class, id);
	}
	
	public void delete(final HocPhan hocPhan) {
	    entityManager.remove(hocPhan);
	}
	
	//Dua ra danh sach hoc phan duoc tim kiem theo ten
}
