<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Tools</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="resources/css/tools.css" />
	<!-- JS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/tools.js"></script>
</head>
<body>
	<div id="header">
		<h1>Modern Logistic S<img class="logoIcon" src="resources/images/citizen_globe.gif" width=25px  height=25px/>ftware</h1>
		<div class="leftIcons">
            <img src="resources/images/market_research.png" width=50px  height=50px/>
            <img src="resources/images/support.png" width=50px  height=50px/>
            <img src="resources/images/checklist.png" width=50px  height=50px/>
            <img src="resources/images/garage.png" width=50px  height=50px/>
            <img src="resources/images/basket.png" width=50px  height=50px/>
        </div>    
        
        <div class="rightIcons">
            <img src="resources/images/car.png" width=50px  height=50px/>
            <img src="resources/images/plain.png" width=50px  height=50px/>
            <img src="resources/images/train.png" width=50px  height=50px/>
            <img src="resources/images/ship.png" width=50px  height=50px/>
            <img src="resources/images/motobike.png" width=50px  height=50px/>
        </div>
	</div>
	<div id="content">
		<div class="leftBar">
	        <div class="back" title="Главная"><a href="<%=request.getContextPath()%>/"><img src="resources/images/left_arrow.png" width=30px height=30px/></a></div>
			<div class="info" title="Info"><a href="toolsInfo"><img src="resources/images/info.png" width=30px height=30px;/></a></div>
		</div>
		<div class="firstline">
			<div class="item"><a href="XML"><img src="resources/images/Xmltool.png" width=150px  height=150px/></a><div class="icon"><h5>XML Converting</h5></div></div>
			<div class="item"><a href="XLS"><img src="resources/images/excel-256.png" width=150px  height=150px/></a><div class="icon"><h5>XLS Converting</h5></div></div>
			<div class="item"><a href="#"><img src="resources/images/closed.png" width=150px  height=150px/></a><div class="icon"><h5>N/A</h5></div></div>
			<div class="item"><a href="#"><img src="resources/images/closed.png" width=150px  height=150px/></a><div class="icon"><h5>N/A</h5></div>
            </div>
		</div>
		
		<div class="secondline">
			<div class="item"><a href="#"><img src="resources/images/closed.png" width=150px height=150px;/></a><div class="icon"><h5>N/A</h5></div></div>
			<div class="item"><a href="#"><img src="resources/images/closed.png" width=150px height=150px/></a><div class="icon"><h5>N/A</h5></div></div>
			<div class="item"><a href="#"><img src="resources/images/closed.png" width=150px height=150px/></a><div class="icon"><h5>N/A</h5></div></div>
			<div class="item end"><a href="#"><img src="resources/images/closed.png" width=150px height=150px/></a><div class="icon"><h5>N/A</h5></div></div>
		</div>
	</div>
	<div id="footer">
	   <h1>Tools</h1>
	</div>
</body>
</html>