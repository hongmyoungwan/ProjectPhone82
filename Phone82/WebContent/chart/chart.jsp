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
        	<td><input id="alpha" type="range" min="0" max="45" value="15"/> <span id="alpha-value" class="value"></span></td>
        </tr>
        <tr>
        	<td>Beta Angle</td>
        	<td><input id="beta" type="range" min="-45" max="45" value="15"/> <span id="beta-value" class="value"></span></td>
        </tr>
        <tr>
        	<td>Depth</td>
        	<td><input id="depth" type="range" min="20" max="100" value="50"/> <span id="depth-value" class="value"></span></td>
        </tr>
    </table>
</div>


		<script type="text/javascript">

// Set up the chart
var chart = new Highcharts.Chart({
    chart: {
        renderTo: 'container',
        type: 'column',
        options3d: {
            enabled: true,
            alpha: 15,
            beta: 15,
            depth: 50,
            viewDistance: 25
        }
    },
    title: {
        text: 'phone82 판매 내역'
    },
    subtitle: {
        text: '통신사별 연간 판매 내역'
    },
    plotOptions: {
        column: {
            depth: 25
        }
    },
    
    series: [{name: 'LG',
        data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
    },{name: 'KT',
        data: [2.9, 51.5, 56.4, 159.2, 155.0,146.0, 55.6, 187.5, 456.4, 112.1, 44.6, 4.4]
    },{name: 'SKT',
        data: [29.9, 51.5, 106.4, 159.2, 144.0, 146.0, 135.6, 187.5, 216.4, 44.6, 55.6, 95.6]}
    ]
});

function showValues() {
    $('#alpha-value').html(chart.options.chart.options3d.alpha);
    $('#beta-value').html(chart.options.chart.options3d.beta);
    $('#depth-value').html(chart.options.chart.options3d.depth);
}

// Activate the sliders
$('#sliders input').on('input change', function () {
    chart.options.chart.options3d[this.id] = parseFloat(this.value);
    showValues();
    chart.redraw(false);
});

showValues();
		</script>
