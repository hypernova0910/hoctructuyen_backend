package com.spring.backend.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HocPhan.class)
public abstract class HocPhan_ {

	public static volatile SingularAttribute<HocPhan, Long> mahocphan;
	public static volatile SingularAttribute<HocPhan, String> tenHocPhan;
	public static volatile SetAttribute<HocPhan, LopHoc> lopHocs;
}
