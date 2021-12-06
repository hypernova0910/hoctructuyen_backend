package com.spring.backend.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table (name = "nhomfilesv")

public class NhomFileSV {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idnhomfile;
	
	@Column (name = "lansuacuoi")
	private LocalDateTime lanSuaCuoi;
	
	@Column (name = "diem")
	private Double diem;
	
	@Column (name = "nhanxet", length = 1000)
	private String nhanXet;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn (name = "masinhvien")
	private SinhVien sinhVien;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn (name = "maquatrinh")
	private QuaTrinhHoc quaTrinhHoc;

	@OneToMany(mappedBy="nfsv")
	private List<FileSinhVien> fileSinhViens;
	
	public NhomFileSV() {}

	public NhomFileSV(double diem, String nhanXet, SinhVien sinhVien, QuaTrinhHoc quaTrinhHoc) {
		this.lanSuaCuoi = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
		this.diem = diem;
		this.nhanXet = nhanXet;
		this.sinhVien = sinhVien;
		this.quaTrinhHoc = quaTrinhHoc;
	}

	public Long getIdnhomfile() {
		return idnhomfile;
	}

	public void setIdnhomfile(Long idnhomfile) {
		this.idnhomfile = idnhomfile;
	}

	public LocalDateTime getLanSuaCuoi() {
		return lanSuaCuoi;
	}

	public void setLanSuaCuoi() {
		this.lanSuaCuoi = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
	}

	public Double getDiem() {
		return diem;
	}

	public void setDiem(Double diem) {
		this.diem = diem;
	}

	public String getNhanXet() {
		return nhanXet;
	}

	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public QuaTrinhHoc getQuaTrinhHoc() {
		return quaTrinhHoc;
	}

	public void setQuaTrinhHoc(QuaTrinhHoc quaTrinhHoc) {
		this.quaTrinhHoc = quaTrinhHoc;
	}
}
