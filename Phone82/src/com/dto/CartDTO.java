package com.dto;

public class CartDTO {
	
	private String num;
	private String userid;
	private String phone_model_num;
	private String phone_name;
	private String sprice;
	private String scolor;
	private String samount;
	private String simage;
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
		this.sprice = sprice;
		this.scolor = scolor;
		this.samount = samount;
		this.simage = simage;
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
		return sprice;
	}
	public void setSprice(String sprice) {
		this.sprice = sprice;
	}
	public String getScolor() {
		return scolor;
	}
	public void setScolor(String scolor) {
		this.scolor = scolor;
	}
	public String getSamount() {
		return samount;
	}
	public void setSamount(String samount) {
		this.samount = samount;
	}
	public String getSimage() {
		return simage;
	}
	public void setSimage(String simage) {
		this.simage = simage;
	}


	
	
}
