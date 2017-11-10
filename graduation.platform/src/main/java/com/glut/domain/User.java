package com.glut.domain;
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
	protected String username;
	protected String password;
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
