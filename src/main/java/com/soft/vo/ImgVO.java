package com.soft.vo;

public class ImgVO {
	
	private int img_no;
	private String img_orgname;
	private String img_strname;
	private int img_size;
	private int img_item_no;
	public int getImg_no() {
		return img_no;
	}
	public void setImg_no(int img_no) {
		this.img_no = img_no;
	}
	public String getImg_orgname() {
		return img_orgname;
	}
	public void setImg_orgname(String img_orgname) {
		this.img_orgname = img_orgname;
	}
	public String getImg_strname() {
		return img_strname;
	}
	public void setImg_strname(String img_strname) {
		this.img_strname = img_strname;
	}
	public int getImg_size() {
		return img_size;
	}
	public void setImg_size(int img_size) {
		this.img_size = img_size;
	}
	public int getImg_item_no() {
		return img_item_no;
	}
	public void setImg_item_no(int img_item_no) {
		this.img_item_no = img_item_no;
	}
	@Override
	public String toString() {
		return "ImgVO [img_no=" + img_no + ", img_orgname=" + img_orgname + ", img_strname=" + img_strname
				+ ", img_size=" + img_size + ", img_item_no=" + img_item_no + "]";
	}
	
	
}
