package com.spring.backend.model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FileGiaoVien.class)
public abstract class FileGiaoVien_ {

	public static volatile SingularAttribute<FileGiaoVien, Long> idfilegv;
	public static volatile SingularAttribute<FileGiaoVien, String> tenFile;
	public static volatile SingularAttribute<FileGiaoVien, String> tenFileTrenServer;
	public static volatile SingularAttribute<FileGiaoVien, LocalDateTime> thoiGianGui;
	public static volatile SingularAttribute<FileGiaoVien, GiaoVien> giaoVien;
	public static volatile SingularAttribute<FileGiaoVien, QuaTrinhHoc> quaTrinhHoc;
	
	public static final String IDFILEGV = "idfilegv";
	public static final String TENFILE = "tenFile";
	public static final String TENFILETRENSERVER = "tenFileTrenServer";
	public static final String THOIGIANGUI = "thoiGianGui";
	public static final String GIAOVIEN = "giaoVien";
	public static final String QUATRINHHOC = "quaTrinhHoc";
}
