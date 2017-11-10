package com.glut.domain;
/**
 * 
 * @author Caizhf
 * @date 2017年11月10日下午4:59:17
 * @version v.0.1
 * @email Caizhfy@163.com 
 *
 * <p>Description:学生 </p>
 *
 */
public class Student extends User{
	
	private String name;	//名称
	private String sclass;	//班级
	private String contact;	//联系方式（电话号码）
	private Major major;	//所属专业
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}

	
}
