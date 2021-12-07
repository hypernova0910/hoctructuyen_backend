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
	
	public List<QuaTrinhHoc> printAllLearningProcess(SearchObject search) {
		return qthDAO.printAllLearningProcess(search);
	}
	
	public QuaTrinhHoc findById(final Long id) {
	    return qthDAO.findById(id);
	}
	
	public Long save(final QuaTrinhHoc qth) {
	    // check if exist -> throw exception
		qth.setThoiGianTao();
		Long saveID = qthDAO.persist(qth);
		return saveID;
	}
	public void update(final QuaTrinhHoc qth) {
		// check if not exist -> throw excpetion
		QuaTrinhHoc qthDb = qthDAO.findById(qth.getMaquatrinh());
		qthDb.setTenQuaTrinh(qth.getTenQuaTrinh());
		qthDb.setMoTa(qth.getMoTa());
		qthDb.setYeuCauNopBai(qth.getYeuCauNopBai());
		qthDb.setThoiGianNop(qth.getThoiGianNop());
		qthDAO.persist(qthDb);
	}
	
	public void delete(final Long id) {
		QuaTrinhHoc qth = qthDAO.findById(id);
	    if (qth != null) {
	    	qthDAO.delete(qth);
	    }
	}
}