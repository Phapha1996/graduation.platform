package com.glut.user.service.TeacherService;

import java.util.List;

import com.glut.domain.Teacher;

public interface TeacherService {
	/**
	 * 按条件查找老师
	 * @param teacher
	 * @return
	 */
	List<Teacher> selectTeacher(Teacher teacher);
	
	/**
	 * 更新老师信息
	 * @param teacher
	 */
	void editTeacher(Teacher teacher);
}
