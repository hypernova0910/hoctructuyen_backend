package com.spring.backend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "sinhvien")
public class SinhVien {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long masinhvien;
	
	@Column (name = "tensinhvien")
	private String tenSinhVien;
	
	@Column (name = "sdt")
	private String sdt;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "pass")
	private String password;
	
	@OneToMany(mappedBy="sinhVien", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ChiTietLopHoc> chiTietLopHocs;
	
	@OneToMany(mappedBy="sinhVien", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<NhomFileSV> nhomFileSVs;
	
	private Date lansuacuoi;
	
	private Double diem;
	
	private Long idnhomfile;

	public Long getMasinhvien() {
		return masinhvien;
	}

	public void setMasinhvien(Long masinhvien) {
		this.masinhvien = masinhvien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLansuacuoi() {
		return lansuacuoi;
	}

	public void setLansuacuoi(Date lansuacuoi) {
		this.lansuacuoi = lansuacuoi;
	}

	public Double getDiem() {
		return diem;
	}

	public void setDiem(Double diem) {
		this.diem = diem;
	}

	public Long getIdnhomfile() {
		return idnhomfile;
	}

	public void setIdnhomfile(Long idnhomfile) {
		this.idnhomfile = idnhomfile;
	}
}
