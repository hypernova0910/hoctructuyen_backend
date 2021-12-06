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

import com.spring.backend.model.LopHoc;
import com.spring.backend.model.NhomFileSV;
import com.spring.backend.model.NhomFileSV_;

@Repository(value = "NhomFileSinhVienDAO")
@Transactional(rollbackFor = Exception.class)
public class NhomFileSinhVienDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Long persist(final NhomFileSV nfsv) {
		entityManager.persist(nfsv);
		return nfsv.getIdnhomfile();
	}
	
	public NhomFileSV findById(final Long idsinhvien, final Long idquatrinhhoc) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<NhomFileSV> cq = cb.createQuery(NhomFileSV.class);
		Root<NhomFileSV> nfsvRoot = cq.from(NhomFileSV.class);
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(nfsvRoot.get(NhomFileSV_.sinhVien), idsinhvien));
		predicates.add(cb.equal(nfsvRoot.get(NhomFileSV_.quaTrinhHoc), idquatrinhhoc));
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<NhomFileSV> query = entityManager.createQuery(cq);
		return query.getResultList().stream().findFirst().orElse(null);
	}
	
	public NhomFileSV findByIdNFSV(final Long idnfsv) {
		return entityManager.find(NhomFileSV.class, idnfsv);
	}

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