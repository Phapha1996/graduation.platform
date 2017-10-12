package com.glut.user.service;

import java.util.List;

import com.glut.domain.Student;
import com.glut.dto.PageBean;
/**
 * 
 * @author Caizhf
 * @date 2017年11月10日下午10:55:06
 * @version v.0.1
 * @email Caizhfy@163.com 
 *
 * <p>Description: </p>
 *
 */
public interface StudentService {

	/**
	 * 批量插入数据
	 * @param students
	 * @return
	 */
	Integer batchInsert(List<Student> students);

	Integer save(Student student);

	Student find(int id);

	Integer update(Student student);

	Integer delete(int sid);

	PageBean<Student> list(int pageNum, int pageSize, Boolean isSelect,Integer major,String snum,String sname);

}
