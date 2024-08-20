package com.soft.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VisitCountVO extends Common{

	private int visit_id;
	private String visit_ip;
	private String regdate;
	
	private String me_name; // 계정 아이디 불러오기용
	
	
	private int visitAprvCnt;
	
	private int dayCnt;
	private int weekCnt;
	private int monthCnt;
	private int yearCnt;
	

}
