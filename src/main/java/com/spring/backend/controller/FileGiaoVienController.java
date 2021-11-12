package com.spring.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.backend.common.Constants;
import com.spring.backend.common.SearchObject;
import com.spring.backend.model.FileGiaoVien;
import com.spring.backend.service.FileGiaoVienService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping(Constants.API_URL + "filegiaovien")
public class FileGiaoVienController {

	@Autowired
	private FileGiaoVienService fileGVService;
	
	@PostMapping("uploadfiles")
	public void uploadFileController(@RequestPart("idgiaovien") Long idgiaovien, @RequestPart("idquatrinhhoc") Long idquatrinhhoc, @RequestPart("files") MultipartFile[] files) throws IOException {
		fileGVService.uploadFileService(idgiaovien, idquatrinhhoc, files);
	}
	
	@PostMapping("downloadfile")
	public void downloadFileController(@RequestPart("idgiaovien") Long idgiaovien, @RequestPart("idfilegiaovien") Long idfilegiaovien, @RequestPart("file") MultipartFile file) {
		
	}
	
	@PostMapping("deletefiles")
	public void deleteFileController(@RequestBody SearchObject search) {
		fileGVService.deleteFileService(search);
	}
	
	@PostMapping("printallfiles")
	public List<FileGiaoVien> printFileController(@RequestBody SearchObject search) {
		return fileGVService.printFileService(search);
	}
}
