package com.spring.backend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "filesinhvien")
public class FileSinhVien {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idfilesv;
	
	@Column (name = "tenfile")
	private String tenFile;
	
	@Column (name = "thoigiangui")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date thoiGianGui;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "idnhomfile")
	private NhomFileSV nfsv;
	

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

	public Date getThoiGianGui() {
		return thoiGianGui;
	}

	public void setThoiGianGui(Date thoiGianGui) {
		this.thoiGianGui = thoiGianGui;
	}

	public NhomFileSV getNfsv() {
		return nfsv;
	}

	public void setNfsv(NhomFileSV nfsv) {
		this.nfsv = nfsv;
	}
}
