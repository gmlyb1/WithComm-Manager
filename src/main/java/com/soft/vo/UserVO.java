package com.soft.vo;

import java.util.Date;

public class UserVO {

	private String userid;
	private String userpw;
	private String userName;
	private String useremail;
	private Date regdate;
	
	// GETTER와 SETTER 메서드
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	// TOSTRING 메서드
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", userpw=" + userpw + ", userName=" + userName + ", useremail=" + useremail
				+ ", regdate=" + regdate + "]";
	}
	
	
	
}
