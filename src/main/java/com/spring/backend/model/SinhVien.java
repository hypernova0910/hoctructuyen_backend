package com.spring.backend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
//	@OneToMany (mappedBy="sinhvien", cascade = CascadeType.ALL)
//	private Set<ChiTietLopHoc> chitietlophoc;
//
//	public Set<ChiTietLopHoc> getChitietlophoc() {
//		return chitietlophoc;
//	}
//
//	public void setChitietlophoc(Set<ChiTietLopHoc> chitietlophoc) {
//		this.chitietlophoc = chitietlophoc;
//	}

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
}
