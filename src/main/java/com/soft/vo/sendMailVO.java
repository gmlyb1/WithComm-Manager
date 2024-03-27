package com.soft.vo;

import lombok.ToString;

import lombok.Setter;

import java.sql.Timestamp;

import lombok.Getter;

@Getter
@Setter
@ToString
public class sendMailVO {
	
	private int mail_num;
	private String mail_id;
	private String mail_email;
	private Timestamp mail_regdate;
	private String mail_title;
	private String mail_content;
	private String mail_file;
}
