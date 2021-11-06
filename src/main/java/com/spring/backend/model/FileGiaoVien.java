package com.spring.backend.model;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name ="filegiaovien")
public abstract class FileGiaoVien {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idfilegv;
	
	@Column (name = "tenfile")
	private String tenFile;
	
	@Column (name = "tenfiletrenserver")
	private String tenFileTrenServer;
	
	@Column (name = "thoigiangui")
	private LocalDateTime thoiGianGui;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(name = "magiaovien")
	private GiaoVien giaoVien;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(name = "maquatrinh")
	private QuaTrinhHoc quaTrinhHoc;

	public Long getIdfilegv() {
		return idfilegv;
	}

	public void setIdfilegv(Long idfilegv) {
		this.idfilegv = idfilegv;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public String getTenFileTrenServer() {
		return tenFileTrenServer;
	}

	public void setTenFileTrenServer(String tenFileTrenServer) {
		this.tenFileTrenServer = tenFileTrenServer;
	}

	public LocalDateTime getThoiGianGui() {
		return thoiGianGui;
	}

	public void setThoiGianGui() {
		this.thoiGianGui = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
	}

	public GiaoVien getGiaoVien() {
		return giaoVien;
	}

	public void setGiaoVien(GiaoVien giaoVien) {
		this.giaoVien = giaoVien;
	}

	public QuaTrinhHoc getQuaTrinhHoc() {
		return quaTrinhHoc;
	}

	public void setQuaTrinhHoc(QuaTrinhHoc quaTrinhHoc) {
		this.quaTrinhHoc = quaTrinhHoc;
	}
}
