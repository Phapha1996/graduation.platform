package com.glut.user.mapper;

import org.apache.ibatis.annotations.Param;

import com.glut.domain.User;

public interface UserMapper {

	User findByUsernameAndPassword(@Param("userType")int userType, 
			@Param("username")String username, @Param("password")String password);
	
}
