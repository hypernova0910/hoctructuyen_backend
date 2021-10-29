//package com.spring.backend.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.spring.backend.common.SearchObject;
//import com.spring.backend.dao.ClassInfoDAO;
//import com.spring.backend.model.ClassInfo;
//
//@Service
//@Transactional
//public class ClassInfoService {
//	@Autowired
//	private ClassInfoDAO classInforDAO;
//	
//	public List<ClassInfo> findAll(SearchObject search, int offset, int limit) {
//		return classInforDAO.findAll(search, offset, limit);
//	}
//	
//	public ClassInfo findById(final Long id) {
//	    return classInforDAO.findById(id);
//	}
//	
//	public void save(final ClassInfo classInfo) {
//	    // check if exist -> throw exception
//		classInforDAO.persist(classInfo);
//	}
//	public void update(final ClassInfo classInfo) {
//		// check if not exist -> throw excpetion
//		ClassInfo classInfoDb = classInforDAO.findById(classInfo.getId());
//		classInfoDb.setDayOfWeek(classInfo.getDayOfWeek());
//		classInfoDb.setDescription(classInfo.getDescription());
//		classInfoDb.setImage(classInfo.getImage());
//		classInfoDb.setLink(classInfoDb.getLink());
//		classInfoDb.setPeriodEnd(classInfo.getPeriodEnd());
//		classInfoDb.setPeriodStart(classInfo.getPeriodStart());
//		classInfoDb.setTeacher(classInfo.getTeacher());
//		classInfoDb.setTitle(classInfo.getTitle());
//		classInforDAO.persist(classInfoDb);
//	}
//	
//	public void delete(final Long id) {
//		ClassInfo classInfo = classInforDAO.findById(id);
//	    if (classInfo != null) {
//	    	classInforDAO.delete(classInfo);
//	    }
//	}
//}
