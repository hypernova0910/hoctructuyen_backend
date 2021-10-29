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
@Table (name = "quatrinhhoc")
public class QuaTrinhHoc {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long maquatrinh;
	
	@Column (name = "tenquatrinh")
	private String tenQuaTrinh;
	
	@Column (name = "thoigiantao")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date thoiGianTao;

	@Column (name = "yeucaunopbai")
	private Boolean yeuCauNopBai;
	
	@Column (name = "thoigiannop")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date thoiGianNop;
	
	@ManyToOne(cascade = CascadeType.ALL)
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
	
	public Date getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(Date thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
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
