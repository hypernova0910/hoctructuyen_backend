package com.spring.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table (name = "lophoc")
public class LopHoc {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long malophoc;
	
	@Column (name = "ky")
	private int ky;
	
	@Column (name = "namhoc")
	private int namHoc;
	
	@Column (name = "tenlophoc")
	private String tenLopHoc;
	
	@Column(name = "ngayhoc")
	private int ngayHoc;
	
	@Column(name = "thoigianbatdau")
	private int thoiGianBatDau;
	
	@Column(name = "thoigianketthuc")
	private int thoiGianKetThuc;
	
	@Column(name = "link")
	private String link;
	
	@Column(name = "mota", length = 1000)
	private String moTa;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn (name = "magiaovien")
	private GiaoVien giaoVien;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn (name = "mahocphan")
	private HocPhan hocPhan;
	
	@OneToMany(mappedBy="lopHoc", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ChiTietLopHoc> chiTietLopHocs = new ArrayList<>();
	@OneToMany(mappedBy="lopHoc")
	private List<QuaTrinhHoc> quaTrinhHocs = new ArrayList<>();

	public int getNgayHoc() {
		return ngayHoc;
	}

	public void setNgayHoc(int ngayHoc) {
		this.ngayHoc = ngayHoc;
	}

	public int getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(int thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public int getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(int thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Long getMalophoc() {
		return malophoc;
	}

	public void setMalophoc(Long malophoc) {
		this.malophoc = malophoc;
	}

	public int getKy() {
		return ky;
	}

	public void setKy(int ky) {
		this.ky = ky;
	}

	public int getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(int namHoc) {
		this.namHoc = namHoc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTenLopHoc() {
		return tenLopHoc;
	}

	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}

	public GiaoVien getGiaoVien() {
		return giaoVien;
	}

	public void setGiaoVien(GiaoVien giaoVien) {
		this.giaoVien = giaoVien;
	}

	public HocPhan getHocPhan() {
		return hocPhan;
	}

	public void setHocPhan(HocPhan hocPhan) {
		this.hocPhan = hocPhan;
	}
	
}
