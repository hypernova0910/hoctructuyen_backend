package com.spring.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.backend.common.SearchObject;
import com.spring.backend.dao.QuaTrinhHocDAO;
import com.spring.backend.model.QuaTrinhHoc;

@Service
@Transactional
public class QuaTrinhHocService {

	@Autowired
	private QuaTrinhHocDAO qthDAO;
	
	public List<QuaTrinhHoc> findAll(SearchObject search) {
		return qthDAO.findAll(search);
	}
	
	public QuaTrinhHoc findById(final Long id) {
	    return qthDAO.findById(id);
	}
	
	public void save(final QuaTrinhHoc classInfo) {
	    // check if exist -> throw exception
		qthDAO.persist(classInfo);
	}
	public void update(final QuaTrinhHoc qth) {
		// check if not exist -> throw excpetion
		QuaTrinhHoc qthDb = qthDAO.findById(qth.getMaquatrinh());
		qthDb.setTenQuaTrinh(qth.getTenQuaTrinh());
		qthDb.setYeuCauNopBai(qth.getYeuCauNopBai());
		qthDb.setThoiGianNop(qth.getThoiGianNop());
		qthDAO.persist(qthDb);
	}
	
	public void delete(final Long id) {
		QuaTrinhHoc sv = qthDAO.findById(id);
	    if (sv != null) {
	    	qthDAO.delete(sv);
	    }
	}
}
