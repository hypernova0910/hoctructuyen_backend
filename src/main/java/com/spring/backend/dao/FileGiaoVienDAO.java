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
import com.spring.backend.model.FileGiaoVien;
import com.spring.backend.model.FileGiaoVien_;

@Repository(value = "FileGiaoVienDAO")
@Transactional(rollbackFor = Exception.class)
public class FileGiaoVienDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void persist(final FileGiaoVien fgv) {
		entityManager.persist(fgv);
	}
	
	public FileGiaoVien findById(final Long id) {
		return entityManager.find(FileGiaoVien.class, id);
	}
	
	public void delete(@RequestBody SearchObject search) {
		for (Long id : search.getListLong1()){
			FileGiaoVien a = new FileGiaoVien();
			a = findById(id);
			entityManager.remove(a);
		}
	}
	
	public List<FileGiaoVien> printAllDocs(SearchObject search) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<FileGiaoVien> cq = cb.createQuery(FileGiaoVien.class);
		Root<FileGiaoVien> fgvRoot = cq.from(FileGiaoVien.class);
		List<Predicate> predicates = new ArrayList<>();
		if(search.getLong1() != null && search.getLong1() > 0) {
			predicates.add(cb.equal(fgvRoot.get(FileGiaoVien_.giaoVien), search.getLong1()));
		}
		if(search.getLong2() != null && search.getLong2() > 0) {
			predicates.add(cb.equal(fgvRoot.get(FileGiaoVien_.quaTrinhHoc), search.getLong2()));
		}
		
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<FileGiaoVien> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
}
