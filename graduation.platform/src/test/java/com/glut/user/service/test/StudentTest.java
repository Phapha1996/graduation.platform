package com.glut.user.service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.glut.domain.Student;
import com.glut.user.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
	@Autowired
	StudentService service;
	@Test
	public void testList(){
	}
}
