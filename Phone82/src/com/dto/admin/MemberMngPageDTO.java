package com.dto.admin;

import java.util.List;

import com.dto.member.MemberDTO;

public class MemberMngPageDTO {
	
	private List<MemberDTO> m_list;
	private int perPage;
	private int curPage;
	private int textCount;
	public MemberMngPageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberMngPageDTO(List<MemberDTO> m_list, int perPage, int curPage, int textCount) {
		super();
		this.m_list = m_list;
		this.perPage = perPage;
		this.curPage = curPage;
		this.textCount = textCount;
	}
	public List<MemberDTO> getM_list() {
		return m_list;
	}
	public void setM_list(List<MemberDTO> m_list) {
		this.m_list = m_list;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTextCount() {
		return textCount;
	}
	public void setTextCount(int textCount) {
		this.textCount = textCount;
	}

	
}
