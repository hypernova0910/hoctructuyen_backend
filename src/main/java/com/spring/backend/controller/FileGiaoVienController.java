package com.spring.backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.InputStreamResource;

import com.spring.backend.common.Constants;
import com.spring.backend.common.SearchObject;
import com.spring.backend.model.FileGiaoVien;
import com.spring.backend.service.FileGiaoVienService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@ControllerAdvice
@RequestMapping(Constants.API_URL + "filegiaovien")
public class FileGiaoVienController {

	@Value("${spring.servlet.multipart.max-file-size}")
	private String maxFileSize;
	@Autowired
	private FileGiaoVienService fileGVService;
	
	@PostMapping("uploadfiles")
	public void uploadFileController(@RequestPart("idgiaovien") Long idgiaovien, @RequestPart("idquatrinhhoc") Long idquatrinhhoc, @RequestPart("files") MultipartFile[] files) throws IOException {
		fileGVService.uploadFileService(idgiaovien, idquatrinhhoc, files);
	}
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleFileUploadError(RedirectAttributes ra) {
		ra.addFlashAttribute("error", "Khong the upload file lon hon " + maxFileSize);
		return "redirect:/api/hoctructuyen/filegiaovien";
	}
	
//	@ExceptionHandler(MaxUploadSizeExceededException.class)
//	public RedirectView handleFileUploadError() {
//		RedirectView redirectView = new RedirectView();
//		redirectView.setUrl("http://localhost:8080/api/hoctructuyen/filegiaovien");
//		return redirectView;
//	}
	
	@PostMapping("downloadfile")
	public ResponseEntity<InputStreamResource> downloadFileController(@RequestBody SearchObject search) throws FileNotFoundException {
		return fileGVService.downloadFileService(search);
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
