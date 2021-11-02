package com.spring.backend.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table (name = "nhomfilesv")

public class NhomFileSV {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idnhomfile;
	
	@Column (name = "lansuacuoi")
	private LocalDateTime lanSuaCuoi;
	
	@Column (name = "diem")
	private double diem;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn (name = "masinhvien")
	private SinhVien sinhVien;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn (name = "maquatrinh")
	private QuaTrinhHoc quaTrinhHoc;

	@OneToMany(mappedBy="nfsv")
	private Set<FileSinhVien> fileSinhViens;
	

	public Set<FileSinhVien> getFileSinhViens() {
		return fileSinhViens;
	}

	public void setFileSinhViens(Set<FileSinhVien> fileSinhViens) {
		this.fileSinhViens = fileSinhViens;
	}

	public Long getIdnhomfile() {
		return idnhomfile;
	}

	public void setIdnhomfile(Long idnhomfile) {
		this.idnhomfile = idnhomfile;
	}

	public LocalDateTime getLanSuaCuoi() {
		return lanSuaCuoi;
	}

	public void setLanSuaCuoi() {
		this.lanSuaCuoi = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public QuaTrinhHoc getQuaTrinhHoc() {
		return quaTrinhHoc;
	}

	public void setQuaTrinhHoc(QuaTrinhHoc quaTrinhHoc) {
		this.quaTrinhHoc = quaTrinhHoc;
	}
}
