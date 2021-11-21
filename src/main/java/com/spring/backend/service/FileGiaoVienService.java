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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.backend.common.SearchObject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.InputStreamResource;
import com.spring.backend.dao.FileGiaoVienDAO;
import com.spring.backend.dao.GiaoVienDAO;
import com.spring.backend.dao.MediaTypeDAO;
import com.spring.backend.dao.QuaTrinhHocDAO;
import com.spring.backend.model.FileGiaoVien;
import com.spring.backend.model.GiaoVien;
import com.spring.backend.model.QuaTrinhHoc;

@Service
@Transactional
public class FileGiaoVienService {

	@Autowired
	FileGiaoVienDAO fileGiaoVienDAO;
	
	@Autowired
	GiaoVienDAO gvDAO;
	
	@Autowired
	QuaTrinhHocDAO qthDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	public void uploadFileService(Long idgiaovien, Long idquatrinhhoc, MultipartFile[] files) {
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
			GiaoVien gv = new GiaoVien();
			gv = gvDAO.findById(idgiaovien);
			QuaTrinhHoc qth = new QuaTrinhHoc();
			qth = qthDAO.findById(idquatrinhhoc);
			FileGiaoVien fgv = new FileGiaoVien(f.getOriginalFilename(), tenFileTrenServer, gv, qth);
			fgv.setThoiGianGui();
			fileGiaoVienDAO.persist(fgv);
		});
	}
	
	public ResponseEntity<InputStreamResource> downloadFileService(SearchObject search) throws FileNotFoundException {
		FileGiaoVien fgv = new FileGiaoVien();
		fgv = fileGiaoVienDAO.findById(search.getLong1());
		String path = ("E:\\ProjectWeb\\" + fgv.getTenFileTrenServer());
		MediaType mediaType = MediaTypeDAO.getMediaTypeForFileName(servletContext, fgv.getTenFileTrenServer());
        System.out.println("fileName: " + path);
//        System.out.println("mediaType: " + mediaType);
        File directFile = new File(path);
//        System.out.println("ten: " + directFile.getName());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(directFile));
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Diposition", 
        		String.format("attachment; filename=\"%s\"", directFile.getName()));
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
//        return ResponseEntity.ok()
//                // Content-Disposition
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + directFile.getName())
//                .header(HttpHeaders.CONTENT_ENCODING, "binary")
//                // Content-Type
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                // Contet-Length
//                .contentLength(directFile.length())
//                .body(resource);
        return ResponseEntity.ok()
                .headers(header)
                .contentLength(directFile.length())
                .contentType(mediaType)
                .body(resource);
	}
	
	public void deleteFileService(@RequestBody SearchObject search) {
		fileGiaoVienDAO.delete(search);
	}
	
	public FileGiaoVien findByIdService(final Long id) {
		return fileGiaoVienDAO.findById(id);
	}
	
	public List<FileGiaoVien> printFileService(SearchObject search) {
		return fileGiaoVienDAO.printAllDocs(search);
	}
}
