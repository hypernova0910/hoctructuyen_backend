package com.spring.backend.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
//import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LopHoc.class)
public abstract class LopHoc_ {

	public static volatile SingularAttribute<LopHoc, Long> malophoc;
	public static volatile SingularAttribute<LopHoc, Integer> ky;
	public static volatile SingularAttribute<LopHoc, Integer> namHoc;
	public static volatile SingularAttribute<LopHoc, String> tenLopHoc;
	public static volatile SingularAttribute<LopHoc, Integer> ngayHoc;
	public static volatile SingularAttribute<LopHoc, Integer> thoiGianBatDau;
	public static volatile SingularAttribute<LopHoc, Integer> thoiGianKetThuc;
	public static volatile SingularAttribute<LopHoc, String> link;
	public static volatile SingularAttribute<LopHoc, String> moTa;
	public static volatile SingularAttribute<LopHoc, GiaoVien> giaoVien;
	public static volatile SingularAttribute<LopHoc, HocPhan> hocPhan;
	public static volatile ListAttribute<LopHoc, ChiTietLopHoc> chiTietLopHocs;
	public static volatile ListAttribute<LopHoc, QuaTrinhHoc> quaTrinhHocs;
	
	public static final String MALOPHOC = "malophoc";
	public static final String KY = "ky";
	public static final String NAMHOC = "namHoc";
	public static final String TENLOPHOC = "tenLopHoc";
	public static final String NGAYHOC = "ngayHoc";
	public static final String THOIGIANBATDAU = "thoiGianBatDau";
	public static final String THOIGIANKETTHUC = "thoiGianKetThuc";
	public static final String LINK = "link";
	public static final String MOTA = "moTa";
	public static final String GIAOVIEN = "giaoVien";
	public static final String HOCPHAN = "hocPhan";
	public static final String CHITIETLOPHOCS = "chiTietLopHocs";
	public static final String QUATRINHHOCS = "quaTrinhHocs";
}
