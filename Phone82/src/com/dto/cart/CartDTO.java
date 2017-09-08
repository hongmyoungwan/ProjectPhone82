package com.dto.cart;

public class CartDTO {
	
	private String num;
	private String userid;
	private String phone_model_num;
	private String phone_name;
	private String phone_price;
	private String phone_color;
	private String phone_amount;
	private String phone_image;
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDTO(String num, String userid, String phone_model_num, String phone_name, String sprice, String scolor,
			String samount, String simage) {
		super();
		this.num = num;
		this.userid = userid;
		this.phone_model_num = phone_model_num;
		this.phone_name = phone_name;
		this.phone_price = sprice;
		this.phone_color = scolor;
		this.phone_amount = samount;
		this.phone_image = simage;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPhone_model_num() {
		return phone_model_num;
	}
	public void setPhone_model_num(String phone_model_num) {
		this.phone_model_num = phone_model_num;
	}
	public String getPhone_name() {
		return phone_name;
	}
	public void setPhone_name(String phone_name) {
		this.phone_name = phone_name;
	}
	public String getSprice() {
		return phone_price;
	}
	public void setSprice(String sprice) {
		this.phone_price = sprice;
	}
	public String getScolor() {
		return phone_color;
	}
	public void setScolor(String scolor) {
		this.phone_color = scolor;
	}
	public String getSamount() {
		return phone_amount;
	}
	public void setSamount(String samount) {
		this.phone_amount = samount;
	}
	public String getSimage() {
		return phone_image;
	}
	public void setSimage(String simage) {
		this.phone_image = simage;
	}


	
	
}
