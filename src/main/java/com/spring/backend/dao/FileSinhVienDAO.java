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
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.backend.common.SearchObject;
import com.spring.backend.model.FileSinhVien;
import com.spring.backend.model.FileSinhVien_;

@Repository(value = "FileSinhVienDAO")
@Transactional(rollbackFor = Exception.class)
public class FileSinhVienDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void persist(final FileSinhVien fgv) {
		entityManager.persist(fgv);
	}
	
	public FileSinhVien findById(final Long id) {
		return entityManager.find(FileSinhVien.class, id);
	}
	
	public void delete(@RequestBody SearchObject search) {
		for (Long id : search.getListLong1()){
			FileSinhVien a = new FileSinhVien();
			a = findById(id);
			entityManager.remove(a);
		}
	}
	
	public List<FileSinhVien> printAllDocs(SearchObject search) {
		System.out.println(search.getLong1());
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<FileSinhVien> cq = cb.createQuery(FileSinhVien.class);
		Root<FileSinhVien> fsvRoot = cq.from(FileSinhVien.class);
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(fsvRoot.get(FileSinhVien_.nfsv), search.getLong1()));
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<FileSinhVien> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
}
