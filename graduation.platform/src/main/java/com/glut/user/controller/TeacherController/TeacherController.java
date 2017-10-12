package com.glut.user.controller.TeacherController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glut.domain.Teacher;
import com.glut.dto.Response;
import com.glut.user.service.TeacherService.TeacherService;

@RestController
@RequestMapping("/tehr")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/select")
	public Response selectTeacher(Teacher teacher){
		List<Teacher> tList;
		tList = teacherService.selectTeacher(teacher);
		return Response.success(tList);
	}
	
	@RequestMapping("/edit")
	public Response editTeacher(Teacher teacher){
		teacherService.editTeacher(teacher);
		return Response.success();
	}
	
}
