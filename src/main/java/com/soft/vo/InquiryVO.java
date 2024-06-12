package com.soft.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
public class InquiryVO {

	private int inq_no;
	private String inq_title;
	private String inq_content;
	private String inq_name;
	private Timestamp inq_regdate;
	
	private String me_name;
	private int inqCount;
	private String answerYn;
}
