package com.soft.vo;

import java.util.Arrays;
import java.util.Date;

public class ItemVO {
	
	private int item_no;
	private String item_admin;
	private String item_name;
	private String item_price;
	private String item_size;
	private String item_color;
	private int item_disc;
	private String item_content;
	private String item_imgsub;
	private Date item_date;
	private int item_star;
	private String item_catemain;
	private String item_catesub;
	private String item_subcontent;
	private String item_model;
	private String item_imgmain;
	private String[] item_option;
	private int[] item_vol;
	private String option_content;
	private String option_item_no;
	private int option_vol;
	private int option_no;
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public String getItem_admin() {
		return item_admin;
	}
	public void setItem_admin(String item_admin) {
		this.item_admin = item_admin;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_price() {
		return item_price;
	}
	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}
	public String getItem_size() {
		return item_size;
	}
	public void setItem_size(String item_size) {
		this.item_size = item_size;
	}
	public String getItem_color() {
		return item_color;
	}
	public void setItem_color(String item_color) {
		this.item_color = item_color;
	}
	public int getItem_disc() {
		return item_disc;
	}
	public void setItem_disc(int item_disc) {
		this.item_disc = item_disc;
	}
	public String getItem_content() {
		return item_content;
	}
	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}
	public String getItem_imgsub() {
		return item_imgsub;
	}
	public void setItem_imgsub(String item_imgsub) {
		this.item_imgsub = item_imgsub;
	}
	public Date getItem_date() {
		return item_date;
	}
	public void setItem_date(Date item_date) {
		this.item_date = item_date;
	}
	public int getItem_star() {
		return item_star;
	}
	public void setItem_star(int item_star) {
		this.item_star = item_star;
	}
	public String getItem_catemain() {
		return item_catemain;
	}
	public void setItem_catemain(String item_catemain) {
		this.item_catemain = item_catemain;
	}
	public String getItem_catesub() {
		return item_catesub;
	}
	public void setItem_catesub(String item_catesub) {
		this.item_catesub = item_catesub;
	}
	public String getItem_subcontent() {
		return item_subcontent;
	}
	public void setItem_subcontent(String item_subcontent) {
		this.item_subcontent = item_subcontent;
	}
	public String getItem_model() {
		return item_model;
	}
	public void setItem_model(String item_model) {
		this.item_model = item_model;
	}
	public String getItem_imgmain() {
		return item_imgmain;
	}
	public void setItem_imgmain(String item_imgmain) {
		this.item_imgmain = item_imgmain;
	}
	public String[] getItem_option() {
		return item_option;
	}
	public void setItem_option(String[] item_option) {
		this.item_option = item_option;
	}
	public int[] getItem_vol() {
		return item_vol;
	}
	public void setItem_vol(int[] item_vol) {
		this.item_vol = item_vol;
	}
	public String getOption_content() {
		return option_content;
	}
	public void setOption_content(String option_content) {
		this.option_content = option_content;
	}
	public String getOption_item_no() {
		return option_item_no;
	}
	public void setOption_item_no(String option_item_no) {
		this.option_item_no = option_item_no;
	}
	public int getOption_vol() {
		return option_vol;
	}
	public void setOption_vol(int option_vol) {
		this.option_vol = option_vol;
	}
	public int getOption_no() {
		return option_no;
	}
	public void setOption_no(int option_no) {
		this.option_no = option_no;
	}
	@Override
	public String toString() {
		return "ItemVO [item_no=" + item_no + ", item_admin=" + item_admin + ", item_name=" + item_name
				+ ", item_price=" + item_price + ", item_size=" + item_size + ", item_color=" + item_color
				+ ", item_disc=" + item_disc + ", item_content=" + item_content + ", item_imgsub=" + item_imgsub
				+ ", item_date=" + item_date + ", item_star=" + item_star + ", item_catemain=" + item_catemain
				+ ", item_catesub=" + item_catesub + ", item_subcontent=" + item_subcontent + ", item_model="
				+ item_model + ", item_imgmain=" + item_imgmain + ", item_option=" + Arrays.toString(item_option)
				+ ", item_vol=" + Arrays.toString(item_vol) + ", option_content=" + option_content + ", option_item_no="
				+ option_item_no + ", option_vol=" + option_vol + ", option_no=" + option_no + "]";
	}
	
	
}
