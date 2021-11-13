package com.spring.backend.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.model.NhomFileSV;

@Repository(value = "NhomFileSinhVienDAO")
@Transactional(rollbackFor = Exception.class)
public class NhomFileSinhVienDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void persist(final NhomFileSV nfsv) {
		entityManager.persist(nfsv);
	}
	
	public NhomFileSV findById(final Long id) {
		return entityManager.find(NhomFileSV.class, id);
	}
	
//	public void delete(@RequestBody SearchObject search) {
//		for (Long id : search.getListLong1()){
//			FileSinhVien a = new FileSinhVien();
//			a = entityManager.find(FileSinhVien.class, id);
//			entityManager.remove(a);
//		}
//	}
//	
//	public List<FileSinhVien> printAllDocs(SearchObject search) {
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<FileSinhVien> cq = cb.createQuery(FileSinhVien.class);
//		Root<FileSinhVien> fsvRoot = cq.from(FileSinhVien.class);
//		List<Predicate> predicates = new ArrayList<>();
//		predicates.add(cb.equal(fsvRoot.get(FileSinhVien_.idnhomfile), search.getLong1()));
//		TypedQuery<FileSinhVien> query = entityManager.createQuery(cq);
//		return query.getResultList();
//	}
}