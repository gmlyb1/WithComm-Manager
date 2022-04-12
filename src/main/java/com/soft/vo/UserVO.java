package com.soft.vo;

public class UserVO extends PageVO{

	private String username;
	private String userid;
	private String userpw;
	private String user_auth;
	private String user_email;
	private String user_tel;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUser_auth() {
		return user_auth;
	}
	public void setUser_auth(String user_auth) {
		this.user_auth = user_auth;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	
	@Override
	public String toString() {
		return "UserVO [username=" + username + ", userid=" + userid + ", userpw=" + userpw + ", user_auth=" + user_auth
				+ ", user_email=" + user_email + ", user_tel=" + user_tel + "]";
	}
	
	
	
	
}
