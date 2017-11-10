package com.glut.domain;
/**
 * 
 * @author Caizhf
 * @date 2017年11月10日下午4:58:01
 * @version v.0.1
 * @email Caizhfy@163.com 
 *
 * <p>Description: 专业</p>
 *
 */
public class Major {
	
	private Integer mid;
	private String name;		//专业名称
	private String description; //描述
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
