package com.dto.admin;

import java.util.List;

import com.dto.member.MemberDTO;

public class MemberMngPageDTO {
	
	private List<MemberDTO> m_list;
	private int perPage;
	private int curPage;
	public MemberMngPageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberMngPageDTO(List<MemberDTO> m_list, int perPage, int curPage) {
		super();
		this.m_list = m_list;
		this.perPage = perPage;
		this.curPage = curPage;
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
	@Override
	public String toString() {
		return "MemberMngPageDTO [" + (m_list != null ? "m_list=" + m_list + ", " : "") + "perPage=" + perPage
				+ ", curPage=" + curPage + "]";
	}
	
	
}
