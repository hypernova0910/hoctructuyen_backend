package com.spring.backend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.spring.backend.common.SearchObject;
import com.spring.backend.dao.FileGiaoVienDAO;
import com.spring.backend.model.FileGiaoVien;

@Service
@Transactional
public class FileGiaoVienService {

	@Autowired
	FileGiaoVienDAO fileGiaoVienDAO;
	
	public void uploadFileService(MultipartFile files) throws IOException {
		fileGiaoVienDAO.uploadFile(files);
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
