package com.neutraining.model;

public class User {
	private String username;
	private String realname;
	private String password;
	private String gender;
	private String phone;
	private String email;
	private String repwd;
	
	//构造方法
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username,String realname, String password, String gender, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
	}

	//getters and setters
	
	
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
