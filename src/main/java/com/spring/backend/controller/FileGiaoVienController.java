package com.spring.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("uploadfile")
	public void uploadFileController(@RequestParam("files") MultipartFile files) throws IOException {
		fileGVService.uploadFileService(files);
	}
	
	@PostMapping("deletefiles")
	public void deleteFileController(@RequestBody FileGiaoVien[] fileGVs) {
		fileGVService.deleteFileService(fileGVs);
	}
	
	@GetMapping("printallfiles")
	public List<FileGiaoVien> printFileController(@RequestBody SearchObject search) {
		return fileGVService.printFileService(search);
	}
}
