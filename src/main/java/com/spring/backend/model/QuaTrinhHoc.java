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
@Table (name = "quatrinhhoc")
public class QuaTrinhHoc {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long maquatrinh;
	
	@Column (name = "tenquatrinh")
	private String tenQuaTrinh;
	
	@Column (name = "yeucaunopbai")
	private Boolean yeuCauNopBai;
	
	@Column (name = "thoigiannop")
	private Date thoiGianNop;
	
	@ManyToOne
	@JoinColumn(name = "malophoc")
	private LopHoc lh;

	public Long getMaquatrinh() {
		return maquatrinh;
	}

	public void setMaquatrinh(Long maquatrinh) {
		this.maquatrinh = maquatrinh;
	}

	public String getTenQuaTrinh() {
		return tenQuaTrinh;
	}

	public void setTenQuaTrinh(String tenQuaTrinh) {
		this.tenQuaTrinh = tenQuaTrinh;
	}

	public Boolean getYeuCauNopBai() {
		return yeuCauNopBai;
	}

	public void setYeuCauNopBai(Boolean yeuCauNopBai) {
		this.yeuCauNopBai = yeuCauNopBai;
	}

	public Date getThoiGianNop() {
		return thoiGianNop;
	}

	public void setThoiGianNop(Date thoiGianNop) {
		this.thoiGianNop = thoiGianNop;
	}

	public LopHoc getLh() {
		return lh;
	}

	public void setLh(LopHoc lh) {
		this.lh = lh;
	}
}
