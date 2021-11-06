package com.spring.backend.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;

import com.spring.backend.common.SearchObject;
import com.spring.backend.model.FileGiaoVien;
import com.spring.backend.model.FileGiaoVien_;
import com.spring.backend.model.GiaoVien;

@Repository(value = "FileGiaoVienDAO")
@Transactional(rollbackFor = Exception.class)
public class FileGiaoVienDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void uploadFile(MultipartFile files) throws IOException {
//		FileGiaoVien fileGV;
//		fileGV.setGiaoVien(search.getString1());
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<FileGiaoVien> cq = cb.createQuery(FileGiaoVien.class);
//		Root<FileGiaoVien> fileGVRoot = cq.from(FileGiaoVien.class);
		
//		Path currentWorkingDir = Paths.get("").toAbsolutePath();
		String path;
//		String path = currentWorkingDir.toString();
//		System.out.println(path);
//		path += "\\src\\main\\java\\FileUpload\\FileGiaoVien\\" + files.getOriginalFilename();
		path = ("E:\\ProjectWeb\\" + files.getOriginalFilename()).toString();
		files.transferTo(new File(path));
		
//		fileGV.setTenFile(files.getOriginalFilename());
//		fileGV.setDuongDan(path);
//		fileGV.setThoiGianGui();
//		fileGV.setGiaoVien(null);
//		fileGV.setQuaTrinhHoc(null);
//		entityManager.createNativeQuery("INSERT INTO filegiaovien(tenfile, duongdan, thoigiangui, magiaovien, maquatrinh) VALUES (?, ?, ?, ?, ?)")
//		.setParameter(1, fileGV.getTenFile())
//		.setParameter(2, fileGV.getDuongDan())
//		.setParameter(3, fileGV.getThoiGianGui())
//		.setParameter(4, fileGV.getGiaoVien().getMagiaovien())
//		.setParameter(5, fileGV.getQuaTrinhHoc().getMaquatrinh());
	}
	
	public FileGiaoVien findById(final Long id) {
		return entityManager.find(FileGiaoVien.class, id);
	}
	
	public void delete(final FileGiaoVien[] fgvs) {
		for (FileGiaoVien i : fgvs) {
			entityManager.remove(i);
		}
	}
	
	public List<FileGiaoVien> printAllDocs(SearchObject search) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<FileGiaoVien> cq = cb.createQuery(FileGiaoVien.class);
		Root<FileGiaoVien> fgvRoot = cq.from(FileGiaoVien.class);
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.equal(fgvRoot.get(FileGiaoVien_.maGiaoVien), search.getString1()));
		predicates.add(cb.equal(fgvRoot.get(FileGiaoVien_.maQuaTrinh), search.getString2()));
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<FileGiaoVien> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
}
