package com.glut.user.service;

import com.glut.domain.User;

/**
 * 
 * @author Caizhf
 * @date 2017年11月10日下午4:41:43
 * @version v.0.1
 * @email Caizhfy@163.com 
 *
 * <p>Description: </p>
 *
 */
public interface UserService {

	User signInByUserType(int userType, String username, String password);

}
