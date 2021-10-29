package com.spring.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table (name = "chitietlophoc")
public class ChiTietLopHoc {
	
	@EmbeddedId
	private SinhVienLopHocKey id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("malophoc")
	@JoinColumn (name = "malophoc")
	private LopHoc lopHoc;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("masinhvien")
	@JoinColumn (name = "masinhvien")
	private SinhVien sinhVien;

	public SinhVienLopHocKey getId() {
		return id;
	}

	public void setId(SinhVienLopHocKey id) {
		this.id = id;
	}

	public LopHoc getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}
	
}
