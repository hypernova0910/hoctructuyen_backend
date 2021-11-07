package com.spring.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backend.common.Constants;
import com.spring.backend.common.SearchObject;
import com.spring.backend.model.LopHoc;
import com.spring.backend.service.LopHocService;

@CrossOrigin(Constants.CROSS_ORIGIN)
@RestController
@RequestMapping(Constants.API_URL + "lophoc")
public class LopHocController {

	@Autowired
	private LopHocService lhService;
	
	@PostMapping("sinhvien/{namhoc}/{ky}")
	public List<LopHoc> getStudentClassInSemester(@RequestBody SearchObject search, @PathVariable int namhoc, @PathVariable int ky){
		return lhService.studentClassInSemesterService(search, namhoc, ky);
	}
	
	@PostMapping("giaovien/{namhoc}/{ky}")
	public List<LopHoc> getAllClassOfTeacherInSemester(@RequestBody SearchObject search, @PathVariable int namhoc, @PathVariable int ky){
		return lhService.teacherClassInSemesterService(search, namhoc, ky);
	}
	
	@PostMapping("sinhvien/getAll/{offset}/{limit}")
	public List<LopHoc> getAllClassOfStudent(@RequestBody SearchObject search, @PathVariable int offset, @PathVariable int limit){
		return lhService.printAllStudentClassService(search, offset, limit);
	}
	
	@PostMapping("giaovien/getAll/{offset}/{limit}")
	public List<LopHoc> getAllClassOfTeacher(@RequestBody SearchObject search, @PathVariable int offset, @PathVariable int limit){
		return lhService.printAllTeacherClassService(search, offset, limit);
	}
	
	@GetMapping("getOneById/{id}")
	public LopHoc getOneById(@PathVariable Long id){
		return lhService.findById(id);
	}
	
	@PostMapping("addLopHoc")
	public void addObj(@RequestBody LopHoc lh){
		lhService.save(lh);
	}
	
	@PostMapping("updateLopHoc")
	public void updateObj(@RequestBody LopHoc lh){
		lhService.update(lh);
	}
	
	@PostMapping("deleteLopHoc")
	public void deleteObj(@RequestBody Long id){
		lhService.delete(id);
	}
}
