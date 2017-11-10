package com.glut.domain;
/**
 * 
 * @author Caizhf
 * @date 2017年11月10日下午4:58:39
 * @version v.0.1
 * @email Caizhfy@163.com 
 *
 * <p>Description: 秘书</p>
 *
 */
public class Secretary extends User{
	
	private String name;	//秘书名称
	private Major major;	//所管专业
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
}
