package com.spring.backend.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GiaoVien.class)
public abstract class GiaoVien_ {

	public static volatile SingularAttribute<GiaoVien, Long> magiaovien;
	public static volatile SingularAttribute<GiaoVien, String> tenGiaoVien;
	public static volatile SingularAttribute<GiaoVien, String> sdt;
	public static volatile SingularAttribute<GiaoVien, String> email;
	public static volatile SingularAttribute<GiaoVien, String> password;
	public static volatile SetAttribute<GiaoVien, FileGiaoVien> fileGiaoViens;
	public static volatile SetAttribute<GiaoVien, LopHoc> lopHocs;
	
	public static final String MAGIAOVIEN = "magiaovien";
	public static final String TENGIAOVIEN = "tenGiaoVien";
	public static final String SDT = "sdt";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String FILEGIAOVIENS = "fileGiaoViens";
	public static final String LOPHOCS = "lopHocs";
}
