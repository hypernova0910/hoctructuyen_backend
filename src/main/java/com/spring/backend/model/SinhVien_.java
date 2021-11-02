package com.spring.backend.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SinhVien.class)
public abstract class SinhVien_ {

	public static volatile SingularAttribute<SinhVien, Long> masinhvien;
	public static volatile SingularAttribute<SinhVien, String> tenSinhVien;
	public static volatile SingularAttribute<SinhVien, String> sdt;
	public static volatile SingularAttribute<SinhVien, String> email;
	public static volatile SingularAttribute<SinhVien, String> password;
	public static volatile SetAttribute<SinhVien, ChiTietLopHoc> chiTietLopHocs;
	public static volatile SetAttribute<SinhVien, NhomFileSV> nhomFileSVs;
}
