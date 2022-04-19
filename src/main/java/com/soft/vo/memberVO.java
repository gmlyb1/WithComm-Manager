package com.soft.vo;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

@Component
public class memberVO extends pageVO{
	
	private int me_idx;
	private String me_name;
	private String me_id;
	private String me_pwd;
	private String me_auth;
	private String me_email;
	private String me_tel;
	private String me_latest_login;
	private String me_delete_yn;
	private String me_regDate;
	private String me_id_yn;
	
	public String getMe_id_yn() {
		return me_id_yn;
	}

	public void setMe_id_yn(String me_id_yn) {
		this.me_id_yn = me_id_yn;
	}

	private String qustr;

	public void setQustr() throws UnsupportedEncodingException {
		String qs = "";
		this.setQustr();
		qs += this.getQustr();
		this.qustr = qs;
	}

	private boolean customCheck;
	
	
	public boolean isCustomCheck() {
		return customCheck;
	}

	public void setCustomCheck(boolean customCheck) {
		this.customCheck = customCheck;
	}

	public int getMe_idx() {
		return me_idx;
	}

	public void setMe_idx(int me_idx) {
		this.me_idx = me_idx;
	}

	public String getMe_name() {
		return me_name;
	}

	public void setMe_name(String me_name) {
		this.me_name = me_name;
	}

	public String getMe_id() {
		return me_id;
	}

	public void setMe_id(String me_id) {
		this.me_id = me_id;
	}

	public String getMe_pwd() {
		return me_pwd;
	}

	public void setMe_pwd(String me_pwd) {
		this.me_pwd = me_pwd;
	}

	public String getMe_auth() {
		return me_auth;
	}

	public void setMe_auth(String me_auth) {
		this.me_auth = me_auth;
	}

	public String getMe_email() {
		return me_email;
	}

	public void setMe_email(String me_email) {
		this.me_email = me_email;
	}

	public String getMe_tel() {
		return me_tel;
	}

	public void setMe_tel(String me_tel) {
		this.me_tel = me_tel;
	}

	public String getMe_latest_login() {
		return me_latest_login;
	}

	public void setMe_latest_login(String me_latest_login) {
		this.me_latest_login = me_latest_login;
	}

	public String getMe_delete_yn() {
		return me_delete_yn;
	}

	public void setMe_delete_yn(String me_delete_yn) {
		this.me_delete_yn = me_delete_yn;
	}

	public String getMe_regDate() {
		return me_regDate;
	}

	public void setMe_regDate(String me_regDate) {
		this.me_regDate = me_regDate;
	}

	public String getQustr() {
		return qustr;
	}

	public void setQustr(String qustr) {
		this.qustr = qustr;
	}

	@Override
	public String toString() {
		return "memberVO [me_idx=" + me_idx + ", me_name=" + me_name + ", me_id=" + me_id + ", me_pwd=" + me_pwd
				+ ", me_auth=" + me_auth + ", me_email=" + me_email + ", me_tel=" + me_tel + ", me_latest_login="
				+ me_latest_login + ", me_delete_yn=" + me_delete_yn + ", me_regDate=" + me_regDate + ", me_id_yn="
				+ me_id_yn + ", qustr=" + qustr + ", customCheck=" + customCheck + "]";
	}

	
	
}
