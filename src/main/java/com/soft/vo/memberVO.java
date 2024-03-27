package com.soft.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class memberVO {

	private int me_id;
	private String me_email;
	private String me_pwd;
	private String me_name;
	private String me_grade;
	private Date me_regDate;
	private String me_image;
	private String me_posi;
	private String me_dept;
	private int adminCk;
	private String state;
	private String aprvStts;
	
	
	
	
	
}
