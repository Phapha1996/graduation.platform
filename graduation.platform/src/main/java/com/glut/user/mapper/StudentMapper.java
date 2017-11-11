package com.glut.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.glut.domain.Student;

public interface StudentMapper {
	/**
	 * 批量保存
	 * @param students
	 * @return
	 */
	Integer batchSave(@Param("list")List<Student> list);

	Integer save(Student student);

	Student findById(int id);

	Integer updateById(Student student);

	Integer deleteById(int sid);

	List<Student> findAll(@Param("isSelect")Boolean isSelect, 
			@Param("majorId")Integer majorId, @Param("snum")String snum, @Param("sname")String sname);

}
