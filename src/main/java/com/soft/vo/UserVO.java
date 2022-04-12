package com.soft.vo;

public class UserVO extends PageVO{

	private String userName;
	private String userId;
	private String userPw;
	private String userAuth;
	private String userEmail;
	private String userTel;
	private String userRegDate;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserRegDate() {
		return userRegDate;
	}
	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}
	
	@Override
	public String toString() {
		return "UserVO [userName=" + userName + ", userId=" + userId + ", userPw=" + userPw + ", userAuth=" + userAuth
				+ ", userEmail=" + userEmail + ", userTel=" + userTel + ", userRegDate=" + userRegDate + "]";
	}
	
	
	
	
	
}
