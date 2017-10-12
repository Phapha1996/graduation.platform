package com.glut.user.service.impl.TeacherServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glut.domain.Teacher;
import com.glut.user.mapper.TeacherMapper;
import com.glut.user.service.TeacherService.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherMapper teacherMapper;
	
	@Override
	public List<Teacher> selectTeacher(Teacher teacher) {
		// TODO 自动生成的方法存根
		List<Teacher> tlist = teacherMapper.findTeacher(teacher);
		return tlist;
	}

	@Override
	public void editTeacher(Teacher teacher) {
		// TODO 自动生成的方法存根
		teacherMapper.updateTeacher(teacher);
	}

}
