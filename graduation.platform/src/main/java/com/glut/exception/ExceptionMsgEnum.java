package com.glut.exception;
/**
 * 
 * @author Caizhf
 * @date 2017年6月11日下午3:08:39
 * @version v.0.1
 * @email 1115054416@qq.com 
 *
 * <p>Description: 异常常量</p>
 *
 */
public enum ExceptionMsgEnum {
	SERVER_ERROR_MSG("操作失败,服务器出现未知错误"),
	DB_NOTEXIT("数据库中已经不存在这条记录了"),
	DB_UPDATE_FAILUE("更新数据失败"),
	DB_INSERT_FAILUE("插入数据失败"),
	DB_DELETE_FAILUE("删除数据失败")
	;
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private ExceptionMsgEnum(String msg) {
		this.msg = msg;
	}
}
