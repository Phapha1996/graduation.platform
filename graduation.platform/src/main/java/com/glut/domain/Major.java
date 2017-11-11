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
	private String mname;		//专业名称
	private String mdescription; //描述
	
	public Major(String mname){
		this.mname = mname;
	}
	
	
	
	public Major(Integer mid, String mname) {
		super();
		this.mid = mid;
		this.mname = mname;
	}



	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMdescription() {
		return mdescription;
	}
	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}
	
	
}
