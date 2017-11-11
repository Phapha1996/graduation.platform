package com.glut.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.glut.domain.Student;
import com.glut.dto.PageBean;
import com.glut.user.mapper.StudentMapper;
import com.glut.user.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;

	@Override
	@Transactional
	public Integer batchInsert(List<Student> students) {
		return studentMapper.batchSave(students);
	}

	@Override
	public Integer save(Student student) {
		return studentMapper.save(student);
	}

	@Override
	public Student find(int id) {
		return studentMapper.findById(id);
	}

	@Override
	public Integer update(Student student) {
		return studentMapper.updateById(student);
	}

	@Override
	public Integer delete(int sid) {
		return studentMapper.deleteById(sid);
	}

	@Override
	@Transactional(readOnly=true)
	public PageBean<Student> list(int pageNum, int pageSize) {
		//mybatis分页插件
		//本行必须在sql的前一句
		Page<?> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Student> students = studentMapper.findAll();
		//自己声明的pageBean，用来设置分页
		PageBean<Student> pageBean = new PageBean<Student>(pageNum, pageSize, (int) page.getTotal());
		pageBean.setItems(students);
		return pageBean;
	}

}
