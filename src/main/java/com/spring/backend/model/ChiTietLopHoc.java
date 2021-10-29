package com.spring.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table (name = "CHITIETLOPHOC")
public class ChiTietLopHoc {
	
	@EmbeddedId
	private SinhVienLopHocKey id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("malophoc")
	@JoinColumn (name = "malophoc")
	private LopHoc lophoc;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("masinhvien")
	@JoinColumn (name = "masinhvien")
	private SinhVien sinhvien;

	public SinhVienLopHocKey getId() {
		return id;
	}

	public void setId(SinhVienLopHocKey id) {
		this.id = id;
	}

	public LopHoc getLophoc() {
		return lophoc;
	}

	public void setLophoc(LopHoc lophoc) {
		this.lophoc = lophoc;
	}

	public SinhVien getSinhvien() {
		return sinhvien;
	}

	public void setSinhvien(SinhVien sinhvien) {
		this.sinhvien = sinhvien;
	}

	
}
