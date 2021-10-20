package com.spring.backend.model;

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
	
	@ManyToOne
	@MapsId("malophoc")
	@JoinColumn (name = "malophoc")
	private LopHoc mlh;
	
	@ManyToOne
	@MapsId("masinhvien")
	@JoinColumn (name = "masinhvien")
	private SinhVien msv;

	public LopHoc getMlh() {
		return mlh;
	}

	public void setMlh(LopHoc mlh) {
		this.mlh = mlh;
	}

	public SinhVien getMsv() {
		return msv;
	}

	public void setMsv(SinhVien msv) {
		this.msv = msv;
	}
	
}
