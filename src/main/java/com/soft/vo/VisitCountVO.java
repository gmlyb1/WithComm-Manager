package com.soft.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VisitCountVO {

	private int visit_id;
	private String visit_ip;
	private String regdate;
	
	private String me_name; // 계정 아이디 불러오기용
	
	
	
	

}
