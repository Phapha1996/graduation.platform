package com.glut.user.mapper;

import java.util.List;

import com.glut.domain.Teacher;


public interface TeacherMapper {
	/**
	 * 按条件查找老师
	 * @param teacher
	 * @return
	 */
	List<Teacher> findTeacher(Teacher teacher);
	
	/**
	 * 更新老师信息
	 * @param teacher
	 */
	void updateTeacher(Teacher teacher);
}
