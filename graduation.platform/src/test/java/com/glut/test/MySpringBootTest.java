package com.glut.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.glut.domain.Teacher;
import com.glut.domain.User;
import com.glut.user.service.UserService;
import com.glut.user.service.TeacherService.TeacherService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringBootTest {
	@Resource
	UserService userService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Test
	public void selectTest(){
		Teacher teacher = new Teacher();
		teacher.setUsername("teac");
		List<Teacher> list = teacherService.selectTeacher(teacher);
		for (Teacher t : list) {
			System.out.println(t);
		}
	}
	
	@Test
	public void updateTest(){
		Teacher teacher = new Teacher();
		teacher.setId(2);
		teacher.setName("pjf");
		teacher.setContact("15678888");
		teacher.setPassword("asdasd");
		teacher.setUsername("asdasd");
		teacherService.editTeacher(teacher);
	}
}
