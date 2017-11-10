package com.glut.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glut.domain.User;
import com.glut.user.mapper.UserMapper;
import com.glut.user.service.UserService;
/**
 * 
 * @author Caizhf
 * @date 2017年11月10日下午6:11:36
 * @version v.0.1
 * @email Caizhfy@163.com 
 *
 * <p>Description: </p>
 *
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User signInByUserType(int userType, String username, String password) {
		User user = userMapper.findByUsernameAndPassword(userType,username,password);
		return user;
	}

}
