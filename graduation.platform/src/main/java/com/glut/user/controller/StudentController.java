package com.glut.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.glut.domain.Student;
import com.glut.dto.Response;
import com.glut.user.service.StudentService;
import com.glut.utils.ExcelUtils;
import com.glut.utils.MsgUtils;

/**
 * 
 * @author Caizhf
 * @date 2017年11月10日下午9:36:57
 * @version v.0.1
 * @email Caizhfy@163.com
 *
 *        <p>
 *        Description:
 *        </p>
 *
 */
@RestController
@RequestMapping("/stu")
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * 利用excel批量插入
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public Response save(@RequestParam("file") MultipartFile file) {
		if (file != null) {
			ExcelUtils excelUtils = new ExcelUtils();
			List<Student> students = excelUtils.getExcelInfo(file, true);
			// 成功逻辑
			// sql批处理将数据插入数据库
			if (students != null && !students.isEmpty()) {
				Integer number = studentService.batchInsert(students);
				// 返回影响数据库的记录数，若记录为零，提示用户未成功
				return Response.success(number);
			}
		}
		return Response.success(MsgUtils.ERROR_MSG.OPERATION_FAILUER);
	}

	@RequestMapping("/add")
	public Response save(@Valid Student student) {
		// 返回影响数据库的记录数，若记录为零，提示用户未成功
		return Response.success(studentService.save(student));
	}

	/**
	 * 多元查询
	 * @param pageNum  起始页
	 * @param pageSize 一页的记录数
	 * @param isSelect 该学生是否已经选题（非必须）
	 * @param major    该学生所属专业（非必须）
	 * @param snum	      该学生学号（非必须）
	 * @param sname	      该学生姓名 （非必须）
	 * @return
	 */
	@RequestMapping("/list/{pageNum}")
	public Response list(@PathVariable int pageNum, @RequestParam("pageSize") int pageSize,
			Boolean isSelect,Integer major,String snum,String sname) {
		return Response.success(studentService.list(pageNum, pageSize,isSelect,major,snum,sname));
	}

	@RequestMapping("/get/{sid}")
	public Response get(@PathVariable int sid) {
		return Response.success(studentService.find(sid));
	}

	@RequestMapping("/update")
	public Response update(@Valid Student student) {
		// 返回影响数据库的记录数，若记录为零，提示用户未成功
		return Response.success(studentService.update(student));
	}

	@RequestMapping("/del/{sid}")
	public Response delete(@PathVariable int sid) {
		return Response.success(studentService.delete(sid));
	}
}
