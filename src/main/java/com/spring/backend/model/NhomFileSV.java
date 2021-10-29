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
@Table (name = "nhomfilesv")

public class NhomFileSV {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idnhomfile;
	
	@Column (name = "lansuacuoi")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date lanSuaCuoi;
	
	@Column (name = "diem")
	private double diem;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "masv")
	private SinhVien msv;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "maquatrinh")
	private QuaTrinhHoc mqt;


	public Long getIdnhomfile() {
		return idnhomfile;
	}

	public void setIdnhomfile(Long idnhomfile) {
		this.idnhomfile = idnhomfile;
	}

	public Date getLanSuaCuoi() {
		return lanSuaCuoi;
	}

	public void setLanSuaCuoi(Date lanSuaCuoi) {
		this.lanSuaCuoi = lanSuaCuoi;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public SinhVien getMsv() {
		return msv;
	}

	public void setMsv(SinhVien msv) {
		this.msv = msv;
	}

	public QuaTrinhHoc getMqt() {
		return mqt;
	}

	public void setMqt(QuaTrinhHoc mqt) {
		this.mqt = mqt;
	}
	
}
