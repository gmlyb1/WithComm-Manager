package com.soft.vo;

import java.util.Date;

public class LogVO {
	
	private int logno;
	private String memberId;
	private int bno;
	private int rno;
	private String questionId;
	private int categori;
	private Date logdate;
	private boardVO bVO;
	private replyVO rVO;
	
	public int getLogno() {
		return logno;
	}
	public void setLogno(int logno) {
		this.logno = logno;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public int getCategori() {
		return categori;
	}
	public void setCategori(int categori) {
		this.categori = categori;
	}
	public Date getLogdate() {
		return logdate;
	}
	public void setLogdate(Date logdate) {
		this.logdate = logdate;
	}
	public boardVO getbVO() {
		return bVO;
	}
	public void setbVO(boardVO bVO) {
		this.bVO = bVO;
	}
	public replyVO getrVO() {
		return rVO;
	}
	public void setrVO(replyVO rVO) {
		this.rVO = rVO;
	}
	
	@Override
	public String toString() {
		return "LogVO [logno=" + logno + ", memberId=" + memberId + ", bno=" + bno + ", rno=" + rno + ", questionId="
				+ questionId + ", categori=" + categori + ", logdate=" + logdate + ", bVO=" + bVO + ", rVO=" + rVO
				+ "]";
	}

	
	
}
