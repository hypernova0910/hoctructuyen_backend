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

@Entity
@Table (name = "filesinhvien")
public class FileSinhVien {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idfilesv;
	
	@Column (name = "tenfile")
	private String tenFile;
	
	@Column (name = "tenfiletrenserver")
	private String tenFileTrenServer;
	
	@Column (name = "thoigiangui")
	private LocalDateTime thoiGianGui;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn (name = "idnhomfile")
	private NhomFileSV nfsv;
	
	public FileSinhVien() {}
	
	public FileSinhVien(String tenFile, String tenFileTrenServer, NhomFileSV nfsv) {
		this.tenFile = tenFile;
		this.tenFileTrenServer = tenFileTrenServer;
		this.thoiGianGui = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
		this.nfsv = nfsv;
	}

	public Long getIdfilesv() {
		return idfilesv;
	}

	public void setIdfilesv(Long idfilesv) {
		this.idfilesv = idfilesv;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public LocalDateTime getThoiGianGui() {
		return thoiGianGui;
	}

	public void setThoiGianGui() {
		this.thoiGianGui = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
	}

	public String getTenFileTrenServer() {
		return tenFileTrenServer;
	}

	public void setTenFileTrenServer(String tenFileTrenServer) {
		this.tenFileTrenServer = tenFileTrenServer;
	}

	public NhomFileSV getNfsv() {
		return nfsv;
	}

	public void setNfsv(NhomFileSV nfsv) {
		this.nfsv = nfsv;
	}
}
