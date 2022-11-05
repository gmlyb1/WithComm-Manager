package com.soft.vo;

import java.util.Date;

public class goodsVO {
	
	private int goodsNum;
	private String goodsName;
	private String cateCode;
	private int goodsPrice;
	private int goodsStock;
	private String goodsDes;
	private String goodsImg;
	private Date goodsDate;
	
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsStock() {
		return goodsStock;
	}
	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}
	public String getGoodsDes() {
		return goodsDes;
	}
	public void setGoodsDes(String goodsDes) {
		this.goodsDes = goodsDes;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public Date getGoodsDate() {
		return goodsDate;
	}
	public void setGoodsDate(Date goodsDate) {
		this.goodsDate = goodsDate;
	}
	
	@Override
	public String toString() {
		return "goodsVO [goodsNum=" + goodsNum + ", goodsName=" + goodsName + ", cateCode=" + cateCode + ", goodsPrice="
				+ goodsPrice + ", goodsStock=" + goodsStock + ", goodsDes=" + goodsDes + ", goodsImg=" + goodsImg
				+ ", goodsDate=" + goodsDate + "]";
	}
	
	
	
}
