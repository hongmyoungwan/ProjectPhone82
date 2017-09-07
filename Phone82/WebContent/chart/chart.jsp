<%@page import="java.util.ArrayList"%>
<%@page import="com.dto.SalesDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="https://code.highcharts.com/highcharts.src.js"></script>

<style type="text/css">
#container, #sliders {
	min-width: 310px;
	max-width: 800px;
	margin: 0 auto;
}

#container {
	height: 400px;
}
</style>
<body>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="chart/highcharts.js"></script>
	<script src="chart/highcharts-3d.js"></script>
	<script src="chart/exporting.js"></script>

	<div id="container"></div>
	<div id="sliders">
		<table>
			<tr>
				<td>Alpha Angle</td>
				<td><input id="alpha" type="range" min="0" max="45" value="15" />
					<span id="alpha-value" class="value"></span></td>
			</tr>
			<tr>
				<td>Beta Angle</td>
				<td><input id="beta" type="range" min="-45" max="45" value="15" />
					<span id="beta-value" class="value"></span></td>
			</tr>
			<tr>
				<td>Depth</td>
				<td><input id="depth" type="range" min="20" max="100"
					value="50" /> <span id="depth-value" class="value"></span></td>
			</tr>
		</table>
	</div>
	
<%
List<SalesDTO> list = (List<SalesDTO>) request.getAttribute("list");
ArrayList<SalesDTO> lg = new ArrayList();
ArrayList<SalesDTO> kt = new ArrayList();
ArrayList<SalesDTO> skt = new ArrayList();

for (int j = 0; j < list.size(); j++) {
	if (1 == list.get(j).getTelecom_num()) {

		kt.add(list.get(j));
	}
	if (2 == list.get(j).getTelecom_num()) {

		lg.add(list.get(j));
	}
	if (3 == list.get(j).getTelecom_num()) {

		skt.add(list.get(j));
	} 
}//for
%>
	
	<script type="text/javascript">
		// Set up the chart
		var chart = new Highcharts.Chart({
			chart : {
				renderTo : 'container',
				type : 'column',
				options3d : {
					enabled : true,
					alpha : 15,
					beta : 15,
					depth : 50,
					viewDistance : 25
				}
			},
			title : {
				text : 'phone82 판매 내역'
			},
			subtitle : {
				text : '통신사별 연간 판매 내역'
			},
			plotOptions : {
				column : {
					depth : 25
				}
			},

			series : [
					{
						name : "kt",
						data : [
						<%=kt.get(0).getPhone_price()%>	,
						<%=kt.get(1).getPhone_price()%>	,
						<%=kt.get(2).getPhone_price()%> ,
						<%=kt.get(3).getPhone_price()%>	,
						<%=kt.get(4).getPhone_price()%>	,
						<%=kt.get(5).getPhone_price()%>	,
						<%=kt.get(6).getPhone_price()%>	,
						<%=kt.get(7).getPhone_price()%>	,
						<%=kt.get(8).getPhone_price()%>	,
						<%=kt.get(9).getPhone_price()%>	,
						<%=kt.get(10).getPhone_price()%>,
						<%=kt.get(11).getPhone_price()%>
						]
					},
					{
						name : "LG",
						data : [
						<%=lg.get(0).getPhone_price()%>	,
						<%=lg.get(1).getPhone_price()%>	,
						<%=lg.get(2).getPhone_price()%> ,
						<%=lg.get(3).getPhone_price()%>	,
						<%=lg.get(4).getPhone_price()%>	,
						<%=lg.get(5).getPhone_price()%>	,
						<%=lg.get(6).getPhone_price()%>	,
						<%=lg.get(7).getPhone_price()%>	,
						<%=lg.get(8).getPhone_price()%>	,
						<%=lg.get(9).getPhone_price()%>	,
						<%=lg.get(10).getPhone_price()%>,
						<%=lg.get(11).getPhone_price()%>
						]
					}
					,
					{
						name : "SKT",
						data : [
						<%=skt.get(0).getPhone_price()%>	,
						<%=skt.get(1).getPhone_price()%>	,
						<%=skt.get(2).getPhone_price()%> ,
						<%=skt.get(3).getPhone_price()%>	,
						<%=skt.get(4).getPhone_price()%>	,
						<%=skt.get(5).getPhone_price()%>	,
						<%=skt.get(6).getPhone_price()%>	,
						<%=skt.get(7).getPhone_price()%>	,
						<%=skt.get(8).getPhone_price()%>	,
						<%=skt.get(9).getPhone_price()%>	,
						<%=skt.get(10).getPhone_price()%>,
						<%=skt.get(11).getPhone_price()%>
						]
					}
				]
			,
			xAxis: {
	            categories: ['1월', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
	                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
	        },
	        legend: {
	            layout: 'vertical',
	            align: 'right',
	            verticalAlign: 'middle',
	            borderWidth: 0
	        }
			
		});

		function showValues() {
			$('#alpha-value').html(chart.options.chart.options3d.alpha);
			$('#beta-value').html(chart.options.chart.options3d.beta);
			$('#depth-value').html(chart.options.chart.options3d.depth);
		}

		// Activate the sliders
		$('#sliders input').on('input change', function() {
			chart.options.chart.options3d[this.id] = parseFloat(this.value);
			showValues();
			chart.redraw(false);
		});

		showValues();
	</script>
	
	
