package com.spring.backend.model;

import java.time.LocalDateTime;

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
import java.time.ZoneId;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table (name = "quatrinhhoc")
public class QuaTrinhHoc {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long maquatrinh;
	
	@Column (name = "tenquatrinh")
	private String tenQuaTrinh;
	
	@Column (name = "thoigiantao")
	private LocalDateTime thoiGianTao;

	@Column (name = "yeucaunopbai")
	private Boolean yeuCauNopBai;
	
	@Column (name = "thoigiannop")
	private LocalDateTime thoiGianNop;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(name = "malophoc")
	private LopHoc lopHoc;
	
	@OneToMany(mappedBy="quaTrinhHoc", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<FileGiaoVien> fileGiaoViens;
	
	@OneToMany(mappedBy="quaTrinhHoc", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<NhomFileSV> nhomFileSVs;

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

	public LocalDateTime getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao() {
		this.thoiGianTao = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
	}

	public Boolean getYeuCauNopBai() {
		return yeuCauNopBai;
	}

	public void setYeuCauNopBai(Boolean yeuCauNopBai) {
		this.yeuCauNopBai = yeuCauNopBai;
	}

	public LocalDateTime getThoiGianNop() {
		return thoiGianNop;
	}

	public void setThoiGianNop(LocalDateTime thoiGianNop) {
		this.thoiGianNop = thoiGianNop;
	}

	public LopHoc getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}
	
}
