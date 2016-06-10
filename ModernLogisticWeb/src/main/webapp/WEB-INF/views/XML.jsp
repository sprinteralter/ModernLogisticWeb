<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>XML</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="resources/css/jquery-ui-xml.css" />
	<!-- JS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
	<script type="text/javascript" src="resources/js/xml.js"></script>
	<script>
        $(function() {
            $( "#tabs" ).tabs();
        });
    </script>
</head>
<body>
	<div id="header">    
        <div class="infoBar">
            <div class="infoBarLeft">
                <div class="infoBarIcon" title="Put your Foto">
                	 <img src="resources/images/userFoto.png" width=70px height=70px;/>
                </div>
            </div>
            <div class="infoBarCenter">
                <h1>Modern Logistic S<img class="logoIcon" src="resources/images/citizen_globe.gif" width=25px  height=25px/>ftware</h1>
            </div>
            <div class="infoBarRight">
            </div>
        </div>
    </div>
    <div id="tabs">
    	<div id="loader">
            <img src="resources/images/cloud_loading_256.gif" alt="Loader" width=150px height=150px;/>
        </div>
        <div id="errormessage">
        	<p class="errMess"></p>
        	<button class="errMessCancel">Отмена</button>
        </div>
        <div id="applymessage">
        	<p class="applMess"></p>
        	<p class="applAjaxMess"></p>
        	<button class="applMessApply" type="submit" form="rightForm">Подтвердить</button><button class="applMessCancel">Отменить</button>
        </div>
        <div id="overlay"></div>
        <ul>
            <li><a href="#tabs-1">Veres</a></li>
            <li><a href="#tabs-2">EDI Novus</a></li>
            <li><a href="#tabs-3">n/a</a></li>
        </ul>
        <div id="tabs-1">
           <div class="leftBar">
                <div class="back" title="Tools"><a href="Tools"><img src="resources/images/left_arrow.png" width=30px height=30px;/></a></div>
                <div class="home" title="Home"><a href="<%=request.getContextPath()%>/"><img src="resources/images/home_w.png" width=30px height=30px;/></a></div>
                <div class="info" title="Info"><a href="Tools"><img src="resources/images/info.png" width=30px height=30px;/></a></div>
            </div>    
            <div class ="leftTA">
                <h3>Choose files</h3>
                <textarea class="textL" disabled></textarea>

                <form id="leftForm" action="uploadFile"  method="POST" enctype="multipart/form-data">
                    <input class="files" type="file" name="file[]" min="1" max="9999" multiple accept="/xml" required="required">
                </form>
                <div class="pushButtLeft">
                    <button class="uplFile" type="submit" form="leftForm"><img src="resources/images/archive-insert.png">Upload files</button>
                </div>
            </div>
            <div class ="buttons">
                <ul>
                    <li class="butt"><a href="XML" title="Refresh"><img src="resources/images/refresh.png" width=50px height=50px;/></a></li>
                    <li class="butt">
                        <a title="Clear"><img src="resources/images/clear.png" width=50px height=50px;/></a>
                    </li>
                </ul>
            </div>
            <div class ="rightTA">
                <h3>Result console</h3>
                <textarea class="textR" disabled></textarea>
                    <form id="rightForm" action="Push" method="get">
                        <select name="dataBase" required="required">
                            <option selected>Alter</option>
                            <option>alter_curent</option>
                            <option>alter_ros</option>
                        </select>
                        <input type="text" name="name" placeholder="login" required="required"/>
                        <input type="password" name="password" placeholder="password" required="required"/>
                    </form>
                <div class="pushButtRight">
                    <button class="push" type="submit" form="rightForm"><img src="resources/images/insert.png">Push Insertion</button>
                </div>
            </div> 
        </div>
        <div id="tabs-2">
            <div class="leftBar">
                <div class="back" title="Tools"><a href="Tools"><img src="resources/images/left_arrow.png" width=30px height=30px;/></a></div>
                <div class="home" title="Home"><a href="<%=request.getContextPath()%>/"><img src="resources/images/home_w.png" width=30px height=30px;/></a></div>
                <div class="info" title="Info"><a href="Tools"><img src="resources/images/info.png" width=30px height=30px;/></a></div>
            </div>    
            <div class ="leftTA">
                <h3>Choose files</h3>
                <textarea class="textL" disabled></textarea>

                <form id="leftForm" action="uploadFile"  method="POST" enctype="multipart/form-data">
                    <input class="files" type="file" name="file[]" min="1" max="9999" multiple accept="/xml" required="required">
                </form>
                <div class="pushButtLeft">
                    <button class="uplFile" type="submit" form="leftForm"><img src="resources/images/archive-insert.png">Upload files</button>
                </div>
            </div>
            <div class ="buttons">
                <ul>
                    <li class="butt"><a href="XML" title="Refresh"><img src="resources/images/refresh.png" width=50px height=50px;/></a></li>
                    <li class="butt">
                        <a title="Clear"><img src="resources/images/clear.png" width=50px height=50px;/></a>
                    </li>
                </ul>
            </div>
            <div class ="rightTA">
                <h3>Result console</h3>
                <textarea class="textR" disabled></textarea>
                    <form id="rightForm" action="Push" method="get">
                        <select name="dataBase" required="required">
                            <option selected>Alter</option>
                            <option>alter_curent</option>
                            <option>alter_ros</option>
                        </select>
                        <input type="text" name="name" placeholder="login" required="required"/>
                        <input type="password" name="password" placeholder="password" required="required"/>
                    </form>
                <div class="pushButtRight">
                    <button class="push" type="submit" form="rightForm"><img src="resources/images/insert.png">Push Insertion</button>
                </div>
            </div> 
        </div>
        <div id="tabs-3">
            <p>Waiting for new applications!</p>
        </div>
    </div> 
    
    <div id="footer">
        <h1>XML Binding</h1>
    </div>
</body>
</html>
