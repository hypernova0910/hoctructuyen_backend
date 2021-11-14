package com.spring.backend.model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QuaTrinhHoc.class)
public abstract class QuaTrinhHoc_ {

	public static volatile SingularAttribute<QuaTrinhHoc, Long> maquatrinh;
	public static volatile SingularAttribute<QuaTrinhHoc, String> tenQuaTrinh;
	public static volatile SingularAttribute<QuaTrinhHoc, String> moTa;
	public static volatile SingularAttribute<QuaTrinhHoc, Boolean> yeuCauNopBai;
	public static volatile SingularAttribute<QuaTrinhHoc, LocalDateTime> thoiGianTao;
	public static volatile SingularAttribute<QuaTrinhHoc, LocalDateTime> thoiGianNop;
	public static volatile SingularAttribute<QuaTrinhHoc, LopHoc> lopHoc;
	public static volatile ListAttribute<QuaTrinhHoc, FileGiaoVien> fileGiaoViens;
	public static volatile ListAttribute<QuaTrinhHoc, NhomFileSV> nhomFileSVs;
	
	public static final String MAQUATRINH = "maquatrinh";
	public static final String TENQUATRINH = "tenQuaTrinh";
	public static final String MOTA = "moTa";
	public static final String YEUCAUNOPBAI = "yeuCauNopBai";
	public static final String THOIGIANTAO = "thoiGianTao";
	public static final String THOIGIANNOP = "thoiGianNop";
	public static final String LOPHOC = "lopHoc";
	public static final String FILEGIAOVIENS = "fileGiaoViens";
	public static final String NHOMFILESV = "nhomFileSVs";
}
