package com.glut.domain;

import javax.validation.constraints.NotNull;

import com.glut.utils.MsgUtils;

/**
 * 
 * @author Caizhf
 * @date 2017年11月10日下午4:51:21
 * @version v.0.1
 * @email Caizhfy@163.com 
 *
 * <p>Description: 抽象用户</p>
 *
 */
public class User {
	
	protected Integer id;
	@NotNull(message = MsgUtils.Valid_MSG.USERNAME_NOT_NULL)
	protected String username;
	@NotNull(message = MsgUtils.Valid_MSG.PASSWORD_NOT_NULL)
	protected String password;
	@NotNull(message = MsgUtils.Valid_MSG.NAME_NOT_NULL)
	protected String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
