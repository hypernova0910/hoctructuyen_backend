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
@Table(name ="filegiaovien")
public class FileGiaoVien {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idfilegv;
	
	@Column (name = "tenfile")
	private String tenFile;
	
	@Column (name = "loaifile")
	private String loaiFile;
	
	@Column (name = "thoigiangui")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date thoiGianGui;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "magiaovien")
	private GiaoVien giaoVien;
	
	@ManyToOne(cascade = CascadeType.ALL)
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

	public String getLoaiFile() {
		return loaiFile;
	}

	public void setLoaiFile(String loaiFile) {
		this.loaiFile = loaiFile;
	}

	public Date getThoiGianGui() {
		return thoiGianGui;
	}

	public void setThoiGianGui(Date thoiGianGui) {
		this.thoiGianGui = thoiGianGui;
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
