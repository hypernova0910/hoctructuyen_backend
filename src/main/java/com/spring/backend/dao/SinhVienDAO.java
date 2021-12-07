package com.spring.backend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.model.QuaTrinhHoc;
import com.spring.backend.model.SinhVien;
import com.spring.backend.common.SearchObject;

@Repository(value = "sinhVienDAO")
@Transactional(rollbackFor = Exception.class)
public class SinhVienDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(final SinhVien sv) {
		entityManager.persist(sv);
	}

	public SinhVien findById(final Long id) {
		System.out.println(id);
		return entityManager.find(SinhVien.class, id);
	}

	public void delete(final SinhVien sv) {
		entityManager.remove(sv);
	}

	// Dua ra danh sach sinh vien duoc tim kiem theo ten
	public List<SinhVien> findAll(SearchObject search, int offset, int limit) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SinhVien> cq = cb.createQuery(SinhVien.class);
		Root<SinhVien> svRoot = cq.from(SinhVien.class);
		if (search.getString1() != "") {
			String[] splitSearch = search.getString1().split(" ");
			List<Predicate> predicates = new ArrayList<>();
			if (splitSearch.length > 0) {
				for (String i : splitSearch) {
					Predicate p1 = cb.like(svRoot.get("tenSinhVien"), "%"+i+"%");
					predicates.add(p1);
				}
			}
			Predicate p2 = cb.or(predicates.toArray(new Predicate[predicates.size()]));
			cq.where(p2);
			TypedQuery<SinhVien> query = entityManager.createQuery(cq);
			query.setFirstResult(offset);
			query.setMaxResults(limit);
			return query.getResultList();
		}
		else {
			return null;
		}
	}
	
	public List<SinhVien> findAllStatusSubmit(SearchObject search, int offset, int limit) {
		QuaTrinhHoc qth = new QuaTrinhHoc();
		if(search.getLong2() != null && search.getLong2() > 0) {
			qth = entityManager.find(QuaTrinhHoc.class, search.getLong2());
		}
		String sql = "SELECT sv.masinhvien, nfsv.idnhomfile, sv.email, sv.pass, sv.sdt, sv.tensinhvien, nfsv.lansuacuoi, case when nfsv.idnhomfile is null then FALSE else TRUE end as danopbai, nfsv.diem FROM sinhvien sv "
				+ "join chitietlophoc ctlh on (ctlh.masinhvien = sv.masinhvien and ctlh.malophoc = :malophoc) "
				+ "left join nhomfilesv nfsv on (nfsv.masinhvien = sv.masinhvien and nfsv.maquatrinh = :maquatrinh) ";
		Query query = entityManager.createNativeQuery(sql, SinhVien.class);
		if(search.getLong2() != null && search.getLong2() > 0) {
			query.setParameter("malophoc", qth.getLopHoc().getMalophoc());
			query.setParameter("maquatrinh", search.getLong2());
		}
		else {
			query.setParameter("malophoc", 0);
			query.setParameter("maquatrinh", 0);
		}
		query.setFirstResult(offset);
		if(limit > 0) {
			query.setMaxResults(limit);
		}
		List<SinhVien> lst = query.getResultList();
		return lst;
	}
}
