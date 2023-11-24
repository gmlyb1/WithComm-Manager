package com.soft.vo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
public class boardVO{
	
	private int rowNo;
	private int board_no;
	private String board_title;
	private String board_content;
	private String board_writer;
	private int board_count;
	private Timestamp board_regdate;
	private int reply_cnt;
	private int boardCnt;
	
	private int dayCnt;
	private int monthCnt;
	private int yearCnt;
	private int allCnt;
	
	
}
