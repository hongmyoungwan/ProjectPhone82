package com.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.AdminDTO;
import com.dto.MonthSales;
import com.dto.SalesDTO;

public class AdminDAO {

	
	public AdminDTO getAdminData(SqlSession session ,HashMap<String,String> map) {
		return session.selectOne("getAdminData",map);
	}

	public List<MonthSales> getSalesChartDatas(SqlSession session, HashMap<String, String> map) {
			
		String month=map.get("start");
		List<SalesDTO> list=null;
		List<MonthSales> months= new ArrayList<>();
		String fromDate =""; // ���� ��¥�� �̾Ƴ�
		  String fromMonth = ""; //���� ���� �̾Ƴ�
		  String fromYear =""; //���� ���� �̾Ƴ�
		  String[] value=month.split("/");
		  fromDate= value[0];
		  fromMonth= value[1];
		  fromYear=value[2];
		  int intFromDate = Integer.parseInt(fromDate); // ��¥�� int������ ������
		  int intFromMonth = Integer.parseInt(fromMonth);
		  int intFtomYear = Integer.parseInt(fromYear);

		  Calendar cal = Calendar.getInstance();
		  
		  cal.set(intFtomYear, intFromMonth-1,intFromDate);
		  int lastDay =cal.getActualMaximum(Calendar.DATE);
		  map.put("lastDay", String.valueOf(lastDay));
		
		
		
		for (int i = 0; i < doDiffOfDate(map); i++) {
			
			list=session.selectList("getSalesChartDatas",month);
			MonthSales mon =new MonthSales();
			mon.setList(list);
			months.add(mon);
		}
		
		 
		return months;
	}
	
	public int doDiffOfDate(HashMap<String,String> map){
		String start = map.get("start");
		String end = map.get("finish");
		int diffDays = 0;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date beginDate = formatter.parse(start);
			Date endDate = formatter.parse(end);
			// �ð����̸� �ð�,��,�ʸ� ���� ������ ������ �Ϸ� ������ ����
			long diff = endDate.getTime() - beginDate.getTime();
			diffDays =(int)( diff / (24 * 60 * 60 * 1000));
			//System.out.println("��¥����=" + ((diffDays / 30) + 1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (diffDays / 30) + 1;
	}
	public String monthChange(String str,int month) {
		
		String[] value=str.split("/");
		String result="";
		for (int i = 0; i < value.length; i++) {
			if(i==1)
			value[i]=String.valueOf(month);	
			result+=value[i];
		}
		
		
		return result;
	}
	
}

