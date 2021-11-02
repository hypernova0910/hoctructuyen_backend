package com.spring.backend.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiTietLopHoc.class)
public abstract class ChiTietLopHoc_ {

	public static volatile SingularAttribute<ChiTietLopHoc, LopHoc> lopHoc;
	public static volatile SingularAttribute<ChiTietLopHoc, SinhVien> sinhVien;
	
	public static final String LOPHOC = "lopHoc";
	public static final String SINHVIEN = "sinhVien";
}
