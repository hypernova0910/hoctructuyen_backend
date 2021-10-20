package com.spring.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SinhVienLopHocKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6044861918304053195L;

	@Column (name = "malophoc")
	private Long maLopHoc;
	
	@Column (name = "masinhvien")
	private Long maSinhVien;
}
