package com.soft.vo;

import org.springframework.stereotype.Component;

@Component
public class boardVO{

	private int board_no;
	private String board_title;
	private String board_content;
	private String board_writer;
	private int board_count;
	private String board_regdate;
	private int board_hit;
	private int board_reply_hit;
	
	//Á¶È¸¼ö °¹¼ö
		private int reply_count;
	
	public int getReply_count() {
			return reply_count;
		}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public int getBoard_count() {
		return board_count;
	}
	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}
	public String getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public int getBoard_reply_hit() {
		return board_reply_hit;
	}
	public void setBoard_reply_hit(int board_reply_hit) {
		this.board_reply_hit = board_reply_hit;
	}
	
	@Override
	public String toString() {
		return "boardVO [board_no=" + board_no + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_writer=" + board_writer + ", board_count=" + board_count + ", board_regdate=" + board_regdate
				+ ", board_hit=" + board_hit + ", board_reply_hit=" + board_reply_hit + ", reply_count=" + reply_count
				+ "]";
	}
	
	
	
	
	
}
