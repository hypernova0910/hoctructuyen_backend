package com.spring.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "hocphan")
public class HocPhan {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long mahocphan;
	
	@Column (name = "tenhocphan")
	private String tenHocPhan;

	public Long getMahocphan() {
		return mahocphan;
	}

	public void setMahocphan(Long mahocphan) {
		this.mahocphan = mahocphan;
	}

	public String getTenHocPhan() {
		return tenHocPhan;
	}

	public void setTenHocPhan(String tenHocPhan) {
		this.tenHocPhan = tenHocPhan;
	}
	
}
