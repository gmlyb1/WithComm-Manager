package com.soft.vo;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

import com.google.protobuf.Timestamp;

@Component
public class memberVO {
	
	private int me_id;
	private String me_email;
	private String me_pwd;
	private String me_name;
	private String me_dept;
	private String me_posi;
	private Timestamp me_regDate;
	private String me_extension;
	private String me_image;
	
	public int getMe_id() {
		return me_id;
	}
	public void setMe_id(int me_id) {
		this.me_id = me_id;
	}
	public String getMe_email() {
		return me_email;
	}
	public void setMe_email(String me_email) {
		this.me_email = me_email;
	}
	public String getMe_pwd() {
		return me_pwd;
	}
	public void setMe_pwd(String me_pwd) {
		this.me_pwd = me_pwd;
	}
	public String getMe_name() {
		return me_name;
	}
	public void setMe_name(String me_name) {
		this.me_name = me_name;
	}
	public String getMe_dept() {
		return me_dept;
	}
	public void setMe_dept(String me_dept) {
		this.me_dept = me_dept;
	}
	public String getMe_posi() {
		return me_posi;
	}
	public void setMe_posi(String me_posi) {
		this.me_posi = me_posi;
	}
	public Timestamp getMe_regDate() {
		return me_regDate;
	}
	public void setMe_regDate(Timestamp me_regDate) {
		this.me_regDate = me_regDate;
	}
	public String getMe_extension() {
		return me_extension;
	}
	public void setMe_extension(String me_extension) {
		this.me_extension = me_extension;
	}
	public String getMe_image() {
		return me_image;
	}
	public void setMe_image(String me_image) {
		this.me_image = me_image;
	}
	
	@Override
	public String toString() {
		return "memberVO [me_id=" + me_id + ", me_email=" + me_email + ", me_pwd=" + me_pwd + ", me_name=" + me_name
				+ ", me_dept=" + me_dept + ", me_posi=" + me_posi + ", me_regDate=" + me_regDate + ", me_extension="
				+ me_extension + ", me_image=" + me_image + "]";
	}

	
	

	
	
	
}
