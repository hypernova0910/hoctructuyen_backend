package com.spring.backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
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

import com.spring.backend.common.Constants;
import com.spring.backend.common.SearchObject;
import com.spring.backend.model.FileSinhVien;
import com.spring.backend.service.FileSinhVienService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@ControllerAdvice
@RequestMapping(Constants.API_URL + "filesinhvien")
public class FileSinhVienController {

	@Value("${spring.servlet.multipart.max-file-size}")
	private String maxFileSize;
	@Autowired
	private FileSinhVienService fileSVService;
	
	@PostMapping("uploadfiles")
	public void uploadFileController(@RequestPart("idsinhvien") Long idsinhvien, @RequestPart("idquatrinhhoc") Long idquatrinhhoc, @RequestPart("files") MultipartFile[] files) throws IOException {
		fileSVService.uploadFileService(idsinhvien, idquatrinhhoc, files);
	}
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleFileUploadError(RedirectAttributes ra) {
		ra.addFlashAttribute("error", "Khong the upload file lon hon " + maxFileSize);
		return "redirect:/api/hoctructuyen/filesinhvien";
	}
	
	@PostMapping("downloadfile")
	public ResponseEntity<InputStreamResource> downloadFileController(@RequestBody SearchObject search) throws FileNotFoundException {
		return fileSVService.downloadFileService(search);
	}
	
	@PostMapping("deletefiles")
	public void deleteFileController(@RequestBody SearchObject search) {
		fileSVService.deleteFileService(search);
	}
	
	@PostMapping("printallfiles")
	public List<FileSinhVien> printFileController(@RequestBody SearchObject search) {
		return fileSVService.printFileService(search);
	}
}
