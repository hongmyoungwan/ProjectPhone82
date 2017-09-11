package com.dto.board;

public class BoardDTO {
	private int num;
	private String userid;
	private String title;
	private String author;
	private String writeday;
	private String content;
	private int readCnt;
	private String board_image;
	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDTO(int num, String userid, String title, String author, String writeday, String content, int readCnt,
			String board_image) {
		super();
		this.num = num;
		this.userid = userid;
		this.title = title;
		this.author = author;
		this.writeday = writeday;
		this.content = content;
		this.readCnt = readCnt;
		this.board_image = board_image;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public String getBoard_image() {
		return board_image;
	}
	public void setBoard_image(String board_image) {
		this.board_image = board_image;
	}
	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", userid=" + userid + ", title=" + title + ", author=" + author + ", writeday="
				+ writeday + ", content=" + content + ", readCnt=" + readCnt + ", board_image=" + board_image + "]";
	}
	
	
	
	
}
