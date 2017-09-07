package com.dto;

import java.util.List;

public class MonthSales {

	private List<SalesDTO> list;

	public MonthSales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonthSales(List<SalesDTO> list) {
		super();
		this.list = list;
	}

	public List<SalesDTO> getList() {
		return list;
	}

	public void setList(List<SalesDTO> list) {
		this.list = list;
	}
	
	
}
