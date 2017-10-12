package com.glut.domain;
/**
 * 
 * @author Caizhf
 * @date 2017年11月10日下午5:02:32
 * @version v.0.1
 * @email Caizhfy@163.com 
 *
 * <p>Description: 老师</p>
 *
 */
public class Teacher extends User{
	private String name;
	private String contact;		//联系方式
	private String description;	//描述
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", contact=" + contact + ", description=" + description + ", id=" + id
				+ ", username=" + username + ", password=" + password + "]";
	}
	
	
}
