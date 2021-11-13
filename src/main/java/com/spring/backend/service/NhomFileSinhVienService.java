package com.spring.backend.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.backend.common.SearchObject;
import com.spring.backend.dao.NhomFileSinhVienDAO;
import com.spring.backend.model.FileGiaoVien;
import com.spring.backend.model.GiaoVien;
import com.spring.backend.model.NhomFileSV;
import com.spring.backend.model.QuaTrinhHoc;

@Service
@Transactional
public class NhomFileSinhVienService {

	@Autowired
	NhomFileSinhVienDAO nhomFileSinhVienDAO;
	
//	public void uploadFileService(Long idsinhvien, Long idquatrinhhoc, MultipartFile[] files) {
//		Arrays.asList(files).forEach(f -> {
//			String tenFileTrenServer = UUID.randomUUID() + f.getOriginalFilename();
//			String path = ("E:\\ProjectWeb\\" + tenFileTrenServer);
//			try {
//				f.transferTo(new File(path));
//			} catch (IllegalStateException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			GiaoVien gv = new GiaoVien();
//			gv = gvDAO.findById(idgiaovien);
//			QuaTrinhHoc qth = new QuaTrinhHoc();
//			qth = qthDAO.findById(idquatrinhhoc);
//			FileGiaoVien fgv = new FileGiaoVien(f.getOriginalFilename(), tenFileTrenServer, gv, qth);
//			fgv.setThoiGianGui();
//			fileGiaoVienDAO.persist(fgv);
//		});
//	}
	
//	public void deleteFileService(@RequestBody SearchObject search) {
//		fileGiaoVienDAO.delete(search);
//	}
	
	public void save(final NhomFileSV nfsv) {
		nfsv.setLanSuaCuoi();
		nhomFileSinhVienDAO.persist(nfsv);
	}
	
	public void update(final NhomFileSV nfsv) {
		NhomFileSV newNFSV = nhomFileSinhVienDAO.findById(nfsv.getIdnhomfile());
		newNFSV.setLanSuaCuoi();
		newNFSV.setDiem(nfsv.getDiem());
		nhomFileSinhVienDAO.persist(newNFSV);
	}
	
	public NhomFileSV findByIdService(final Long id) {
		return nhomFileSinhVienDAO.findById(id);
	}
	
//	public List<FileGiaoVien> printFileService(SearchObject search) {
//		return fileGiaoVienDAO.printAllDocs(search);
//	}
}