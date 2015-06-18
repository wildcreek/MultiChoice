package com.example.listmultichoise.bean;

public class UserBean extends BaseBean {

	public String uId;// 用户ID
	public String uName;// 登录�?手机�?
	public String uPwd; // 登录密码
	public String uLogName; // 昵称
	public String userCode;
	public String age;// 年龄
	public String sex;// 性别
	public String message;

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
