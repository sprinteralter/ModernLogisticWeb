<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>XML</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="resources/css/jquery-ui-xml.css" />
	<!-- JS -->
	<script type="text/javascript" src="resources/js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
	<script type="text/javascript" src="resources/js/xml.js"></script>
	<script type="text/javascript" src="resources/jquery_plugins/jqueryForm.js"></script>
	<script>
        $(function() {
            $( "#tabs" ).tabs({
            	beforeLoad: function( event, ui ) {
                    ui.jqXHR.fail(function() {
                      ui.panel.html(
                        "Couldn't load this tab. We'll try to fix this as soon as possible. " +
                        "If this wouldn't be a demo." );
                    });
                 }
            });
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
	    <div id="accessmessage">
	       	<p class="accMess"></p>
	      	<button class="accMessOk">Ok</button>
	    </div>
	    <div id="overlay"></div>
    
    <div id="tabs">
        <ul>
            <li><a href="resources/tabs/tab-1.jsp">Veres</a></li>
            <li><a href="resources/tabs/tab-2.jsp">EDI Novus</a></li>
        </ul>
    </div>
    <div id="delegation">
     	<div class="delegatePushButtRight"></div>
     	<div class="delegateUploadButtLeft"></div>
    </div>
    <div id="footer">
        <h3>XML converting</h3>
    </div>
</body>
</html>