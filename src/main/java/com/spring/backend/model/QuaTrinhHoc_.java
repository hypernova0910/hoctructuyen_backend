package com.spring.backend.model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QuaTrinhHoc.class)
public abstract class QuaTrinhHoc_ {

	public static volatile SingularAttribute<QuaTrinhHoc, Long> maquatrinh;
	public static volatile SingularAttribute<QuaTrinhHoc, String> tenQuaTrinh;
	public static volatile SingularAttribute<QuaTrinhHoc, Boolean> yeuCauNopBai;
	public static volatile SingularAttribute<QuaTrinhHoc, LocalDateTime> thoiGianTao;
	public static volatile SingularAttribute<QuaTrinhHoc, LocalDateTime> thoiGianNop;
	public static volatile SingularAttribute<QuaTrinhHoc, Long> malophoc;
	public static volatile SetAttribute<QuaTrinhHoc, FileGiaoVien> fileGiaoViens;
	public static volatile SetAttribute<QuaTrinhHoc, NhomFileSV> nhomFileSVs;
}
