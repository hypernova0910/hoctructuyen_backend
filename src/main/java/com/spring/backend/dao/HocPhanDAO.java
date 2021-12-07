package com.spring.backend.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.model.HocPhan;

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
}
