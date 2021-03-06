package com.spring.backend.model;

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
@Table(name = "giaovien")
public class GiaoVien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long magiaovien;
	
	@Column(name = "tengiaovien")
	private String tenGiaoVien;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "pass")
	private String password;
	
	@OneToMany(mappedBy="giaoVien", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<LopHoc> lopHocs;
	
	@OneToMany(mappedBy="giaoVien", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<FileGiaoVien> fileGiaoViens;
	
	public Long getMagiaovien() {
		return magiaovien;
	}

	public void setMagiaovien(Long magiaovien) {
		this.magiaovien = magiaovien;
	}

	public String getTenGiaoVien() {
		return tenGiaoVien;
	}

	public void setTenGiaoVien(String tenGiaoVien) {
		this.tenGiaoVien = tenGiaoVien;
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

}
