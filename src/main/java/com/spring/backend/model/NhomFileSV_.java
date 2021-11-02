package com.spring.backend.model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NhomFileSV.class)
public abstract class NhomFileSV_ {

	public static volatile SingularAttribute<NhomFileSV, Long> idnhomfile;
	public static volatile SingularAttribute<NhomFileSV, LocalDateTime> lanSuaCuoi;
	public static volatile SingularAttribute<NhomFileSV, Double> diem;
	public static volatile SingularAttribute<NhomFileSV, SinhVien> maSV;
	public static volatile SingularAttribute<NhomFileSV, QuaTrinhHoc> maQuaTrinh;
	public static volatile SetAttribute<NhomFileSV, FileSinhVien> fileSinhViens;
}
