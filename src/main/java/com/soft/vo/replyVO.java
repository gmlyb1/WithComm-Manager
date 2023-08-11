package com.soft.vo;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class replyVO {

	private int board_no;
	private int reply_no;
	private String reply_content;
	private String reply_writer;
	private Date reply_regdate;

	
	
	
	
}
