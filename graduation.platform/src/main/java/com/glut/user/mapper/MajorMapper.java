package com.glut.user.mapper;

import com.glut.domain.Major;

public interface MajorMapper {

	Major findByName(String mname);
	
}
