package com.spring.backend.model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FileSinhVien.class)
public abstract class FileSinhVien_ {

	public static volatile SingularAttribute<FileSinhVien, Long> idfilesv;
	public static volatile SingularAttribute<FileSinhVien, String> tenFile;
	public static volatile SingularAttribute<FileSinhVien, String> tenFileTrenServer;
	public static volatile SingularAttribute<FileSinhVien, LocalDateTime> thoiGianGui;
	public static volatile SingularAttribute<FileSinhVien, NhomFileSV> nfsv;
}
