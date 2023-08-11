package com.soft.vo;

import java.util.Date;

public class LogVo {

	private int memberId;
	private int bno;
	private int rno;
	private String questionId;
	private int categori;
	private Date logdate;
	private boardVO bvo;
	private replyVO rvo;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
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
	public boardVO getBvo() {
		return bvo;
	}
	public void setBvo(boardVO bvo) {
		this.bvo = bvo;
	}
	public replyVO getRvo() {
		return rvo;
	}
	public void setRvo(replyVO rvo) {
		this.rvo = rvo;
	}
	@Override
	public String toString() {
		return "LogVo [memberId=" + memberId + ", bno=" + bno + ", rno=" + rno + ", questionId=" + questionId
				+ ", categori=" + categori + ", logdate=" + logdate + ", bvo=" + bvo + ", rvo=" + rvo + "]";
	}
	
	
}
