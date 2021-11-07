package com.spring.backend.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.backend.common.SearchObject;
import com.spring.backend.dao.FileGiaoVienDAO;
import com.spring.backend.model.FileGiaoVien;

@Service
@Transactional
public class FileGiaoVienService {

	@Autowired
	FileGiaoVienDAO fileGiaoVienDAO;
	
	public void uploadFileService(FileGiaoVien fgv, MultipartFile file) throws IOException {
		String path = ("E:\\ProjectWeb\\" + file.getOriginalFilename());
//		String path = currentWorkingDir.toString();
//		System.out.println(path);
//		path += "\\src\\main\\java\\FileUpload\\FileGiaoVien\\" + files.getOriginalFilename();
		String tenFileTrenServer = file.getOriginalFilename() + UUID.randomUUID(); 
//		FileGiaoVien fgv = new FileGiaoVien(file.getOriginalFilename(), tenFileTrenServer);
		file.transferTo(new File(path));
		
		fgv.setThoiGianGui();
		fgv.setTenFile(file.getOriginalFilename());
		fgv.setTenFileTrenServer(tenFileTrenServer);
		fileGiaoVienDAO.persist(fgv);
	}
	
	public void deleteFileService(FileGiaoVien[] fgvs) {
		fileGiaoVienDAO.delete(fgvs);
	}
	
	public FileGiaoVien fileByIdService(final Long id) {
		return fileGiaoVienDAO.findById(id);
	}
	
	public List<FileGiaoVien> printFileService(SearchObject search) {
		return fileGiaoVienDAO.printAllDocs(search);
	}
}
