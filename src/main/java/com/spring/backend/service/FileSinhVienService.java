package com.spring.backend.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.backend.common.SearchObject;
import com.spring.backend.dao.FileSinhVienDAO;
import com.spring.backend.dao.MediaTypeDAO;
import com.spring.backend.dao.NhomFileSinhVienDAO;
import com.spring.backend.dao.QuaTrinhHocDAO;
import com.spring.backend.model.FileGiaoVien;
import com.spring.backend.model.FileSinhVien;
import com.spring.backend.model.NhomFileSV;

@Service
@Transactional
public class FileSinhVienService {

	@Autowired
	FileSinhVienDAO fileSinhVienDAO;
	
	@Autowired
	QuaTrinhHocDAO quaTrinhHocDAO;
	
	@Autowired
	NhomFileSinhVienDAO nhomFileSinhVienDAO;
	
	@Autowired
	ServletContext servletContext;
	
	public void uploadFileService(Long idsinhvien, Long idquatrinhhoc, MultipartFile[] files) {
		Arrays.asList(files).forEach(f -> {
			String tenFileTrenServer = UUID.randomUUID() + f.getOriginalFilename();
			String path = ("E:\\ProjectWeb\\" + tenFileTrenServer);
			try {
				f.transferTo(new File(path));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			NhomFileSV nfsv = new NhomFileSV();
			nfsv = nhomFileSinhVienDAO.findById(idsinhvien, idquatrinhhoc);
			FileSinhVien fsv = new FileSinhVien(f.getOriginalFilename(), tenFileTrenServer, nfsv);
			fsv.setThoiGianGui();
			nfsv.setLanSuaCuoi();
			fileSinhVienDAO.persist(fsv);
		});
	}
	
	public ResponseEntity<InputStreamResource> downloadFileService(SearchObject search) throws FileNotFoundException {
		FileSinhVien fsv = new FileSinhVien();
		fsv = fileSinhVienDAO.findById(search.getLong1());
		String path = ("E:\\ProjectWeb\\" + fsv.getTenFileTrenServer());
		MediaType mediaType = MediaTypeDAO.getMediaTypeForFileName(servletContext, fsv.getTenFileTrenServer());
        System.out.println("fileName: " + fsv.getTenFileTrenServer());
        System.out.println("mediaType: " + mediaType);
        File directFile = new File(path);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(directFile));
        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + directFile.getName())
                // Content-Type
                .contentType(mediaType)
                // Contet-Length
                .contentLength(directFile.length())
                .body(resource);
	}
	
	public void deleteFileService(@RequestBody SearchObject search) {
		fileSinhVienDAO.delete(search);
	}
	
	public FileSinhVien findByIdService(final Long id) {
		return fileSinhVienDAO.findById(id);
	}
	
	public List<FileSinhVien> printFileService(SearchObject search) {
		return fileSinhVienDAO.printAllDocs(search);
	}
}
