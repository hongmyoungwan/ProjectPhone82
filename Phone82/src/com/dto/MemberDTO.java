package com.dto;

public class MemberDTO {

	private String userid;
	private String passwd;
	private String username;
	private String post1;
	private String post2;
	private String addr1;
	private String addr2;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email;
	
	@Override
	public String toString() {
		return "MemberDTO [" + (userid != null ? "userid=" + userid + ", " : "")
				+ (passwd != null ? "passwd=" + passwd + ", " : "")
				+ (username != null ? "username=" + username + ", " : "")
				+ (post1 != null ? "post1=" + post1 + ", " : "") + (post2 != null ? "post2=" + post2 + ", " : "")
				+ (addr1 != null ? "addr1=" + addr1 + ", " : "") + (addr2 != null ? "addr2=" + addr2 + ", " : "")
				+ (phone1 != null ? "phone1=" + phone1 + ", " : "") + (phone2 != null ? "phone2=" + phone2 + ", " : "")
				+ (phone3 != null ? "phone3=" + phone3 + ", " : "") + (email != null ? "email=" + email : "") + "]";
	}
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String userid, String passwd, String username, String post1, String post2, String addr1,
			String addr2, String phone1, String phone2, String phone3, String email) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.post1 = post1;
		this.post2 = post2;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email = email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPost1() {
		return post1;
	}
	public void setPost1(String post1) {
		this.post1 = post1;
	}
	public String getPost2() {
		return post2;
	}
	public void setPost2(String post2) {
		this.post2 = post2;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
