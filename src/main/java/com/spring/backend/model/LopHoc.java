package com.spring.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "lophoc")
public class LopHoc {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long malophoc;
	
	@Column (name = "ky")
	private String ky;
	
	@Column (name = "tenlophoc")
	private String tenLopHoc;
	
	@Column (name = "lichhoc")
	private String lichHoc;
	
	@ManyToOne
	@JoinColumn (name = "magiaovien")
	private GiaoVien gv;
	
	@ManyToOne
	@JoinColumn (name = "mahocphan")
	private HocPhan mhp;


	public Long getMalophoc() {
		return malophoc;
	}

	public void setMalophoc(Long malophoc) {
		this.malophoc = malophoc;
	}

	public String getKy() {
		return ky;
	}

	public void setKy(String ky) {
		this.ky = ky;
	}

	public String getTenLopHoc() {
		return tenLopHoc;
	}

	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}

	public String getLichHoc() {
		return lichHoc;
	}

	public void setLichHoc(String lichHoc) {
		this.lichHoc = lichHoc;
	}

	public GiaoVien getGv() {
		return gv;
	}

	public void setGv(GiaoVien gv) {
		this.gv = gv;
	}

	public HocPhan getMhp() {
		return mhp;
	}

	public void setMhp(HocPhan mhp) {
		this.mhp = mhp;
	}
	
}
