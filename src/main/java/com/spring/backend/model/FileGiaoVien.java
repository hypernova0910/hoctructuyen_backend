package com.spring.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private Date thoiGianGui;
	
	@ManyToOne
	@JoinColumn(name = "magiaovien")
	private GiaoVien gv;
	
	@ManyToOne
	@JoinColumn(name = "maquatrinh")
	private QuaTrinhHoc qth;


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

	public GiaoVien getGv() {
		return gv;
	}

	public void setGv(GiaoVien gv) {
		this.gv = gv;
	}

	public QuaTrinhHoc getQth() {
		return qth;
	}

	public void setQth(QuaTrinhHoc qth) {
		this.qth = qth;
	}
}
