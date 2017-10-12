package com.glut.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glut.domain.User;
import com.glut.dto.Response;
import com.glut.user.service.UserService;
/**
 * 
 * @author Caizhf
 * @date 2017年11月10日下午3:55:12
 * @version v.0.1
 * @email Caizhfy@163.com 
 *
 * <p>Description: </p>
 *
 */
@RestController
@RequestMapping("/usr")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 	登录
	 * @param userType	用户类型(0学生，1老师，2秘书，3管理员)
	 * @param username	用户名
	 * @param password	密码
	 * @return
	 */
	@RequestMapping("/signin")
	public Response signIn(@RequestParam("type")int userType,
			@RequestParam("username") String username,@RequestParam("password") String password
			,HttpServletRequest req,HttpServletResponse resp){
//		password = Md5Utils.toMD5(password);
		User user = userService.signInByUserType(userType,username,password);
		if(user==null)
			return Response.success("账号或密码错误");		
		req.getSession().setAttribute("user", user);
		return Response.success(user);	//		
	}
	
	
}
