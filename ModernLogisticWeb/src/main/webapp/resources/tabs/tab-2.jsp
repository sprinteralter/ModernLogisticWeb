<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EDI NOVUS</title>
</head>
<body>	    
		<div id="tabs-1">
			
			<div class="leftBar">
				<div class="back" title="Tools">
					<a href="Tools"><img src="resources/images/left_arrow.png"
						width=30px height=30px; /></a>
				</div>
				<div class="home" title="Home">
					<a href="<%=request.getContextPath()%>/"><img
						src="resources/images/home_w.png" width=30px height=30px; /></a>
				</div>
				<div class="info" title="Info">
					<a href="Tools"><img src="resources/images/info.png" width=30px
						height=30px; /></a>
				</div>
			</div>
			<div class="leftTA">
				<h3>Choose files</h3>
				<textarea class="textL" disabled></textarea>
				<div id="leftTADataSection">
					<form id="uploadFilesForm" action="uploadFile" method="post" enctype="multipart/form-data">
		     			<input class="files" type="file" name="file[]" min="1" max="9999"
							multiple accept="/xml" required="required">
		     			<input class="upload" type="submit" value="Загрузить файлы">
				    </form>
				</div>
			    <div id="progress">
			    	<div id="bar"></div>
			    	<div id="percent">0%</div>
			    </div>
			    <script>
				    $(document).ready(function(){
				    
				        var options = { 
					        beforeSend: function(){
						        $("#progress").show();
						    		 //clear everything
						    	$("#bar").width('0%');
						    	$(".textR").html("");
						    	$("#percent").html("0%");
					    	},
							uploadProgress: function(event, position, total, percentComplete){
						    	$("#bar").width(percentComplete+'%');
						    	$("#percent").html(percentComplete+'%');
					    	},
					    	success: function(){
					    		$("#bar").width('100%');
					    		$("#percent").html('100%');
					   	    },
					   	    complete: function(response){	
					    		$(".textR").stop().css({"color":"green"});
					    		$(".textR").html(response.responseText);	    
					   	    },
					    	error: function(){
					    		$(".textR").stop().css({"color":"red"});
					    		$(".textR").html("Ошибка: невозможно загрузить файлы!!");
					    	}
				    	}; 
				    		 
				     	$("#uploadFilesForm").ajaxForm(options);
				    		 
				    });
			    </script>
			</div>
			<div class="buttons">
				<ul>
					<li class="butt"><a href="XML" title="Refresh"><img
							src="resources/images/refresh.png" width=50px height=50px;/></a></li>
					<li class="butt"><a title="Clear"><img
							src="resources/images/clear.png" width=50px height=50px;/></a></li>
				</ul>
			</div>
			<div class="rightTA">
				<h3>Result console</h3>
				<textarea class="textR" disabled></textarea>
				<div id="rightTADataSection">
					<form id="rightForm" action="PushNovus" method="get">
						<select name="dataBase1" required="required"><option
								selected>Alter</option>
							<option>alter_curent</option>
							<option>alter_ros</option></select>
						<input type="text" name="name1"
							placeholder="login" required="required" />
						<input type="password"
							name="password1" placeholder="password" required="required" />
					</form>
					<div class="pushButtRight">
	                     <button class="push" type="submit" form="rightForm">Загрузить данные
	                     </button>
	                </div>
                </div>
                <div id="progressInsertion">
			    	<div id="barInsertion"></div>
			    	<div id="percentInsertion">0%</div>
			    </div>
				<script>
				    $(document).ready(function(){
				    
				        var options = { 
					        beforeSend: function(){
					        	$("#progressInsertion").show();
					    		 //clear everything
					    		$("#barInsertion").width('0%');
					    		$("#percentInsertion").html("0%");
					    	},
							uploadProgress: function(event, position, total, percentComplete){
								$("#barInsertion").width(percentComplete+'%');
						    	$("#percentInsertion").html(percentComplete+'%');
					    	},
					    	success: function(){
					    		$("#barInsertion").width('100%');
					    		$("#percentInsertion").html('100%');
					   	    },
					   	    complete: function(response){
					   	    	$("#loader").css("display","none").animate({opacity: 0, top: "50%"}, 200);
					   	    	$('.accMess').html("Выгрузка данных в базу прошла успешно!!!");
					   	    	$("#accessmessage").fadeIn(200,function(){$(this).css("display", "block").animate({opacity: 1, top: "50%"}, 200);});
					    		$(".textR").stop().css({"color":"green"});
					    		$(".textR").html(response.responseText);	    
					   	    },
					    	error: function(){
					    		$(".textR").stop().css({"color":"red"});
					    		$(".textR").html("Ошибка: невозможно синхронизироваться с базой данных!!");
					    	}
				    	}; 
				    		 
				     	$("#rightForm").ajaxForm(options);
				     	
				     	$(".pushButtRight").click(function(event){ // лoвим клик пo ссылкe
				    		
				    		var check = $('.textR').val();
				    		var preffix = check.slice(0,2);
				    		
				        	if(preffix=="nu"||preffix=="In"){
				        		event.preventDefault(); // выключaем стaндaртную рoль элементa
				        		$("#overlay").fadeIn(200, // снaчaлa плaвнo пoкaзывaем темную пoдлoжку
				        			function(){ // пoсле выпoлнения предъидущей aнимaции
				        					$("#errormessage")
				        						.css("display", "block") // убирaем у мoдaльнoгo oкнa display: none;
				        						.animate({opacity: 1, top: "50%"}, 200); // плaвнo прибaвляем прoзрaчнoсть oднoвременнo сo съезжaнием вниз
				        					$('.errMess').html("Файл для выгрузки отсутствует! Неправильный тип данных, либо выгрузка произведена!");
				        		});
				        	}
				        	else if(preffix=="--"){
				        		event.preventDefault(); // выключaем стaндaртную рoль элементa
				        		$("#overlay").fadeIn(200, // снaчaлa плaвнo пoкaзывaем темную пoдлoжку
				        			function(){ // пoсле выпoлнения предъидущей aнимaции
				        					$("#applymessage")
				        						.css("display", "block") // убирaем у мoдaльнoгo oкнa display: none;
				        						.animate({opacity: 1, top: "50%"}, 200); // плaвнo прибaвляем прoзрaчнoсть oднoвременнo сo съезжaнием вниз
				        					$('.applMess').html("Подтвердить выгрузку данных в базу!");
				        		});
				        	}
				        	
				    	 });
				        /* end */
				        /*errors buttons*/
				        $('.errMessCancel').click(function(){
				        	$('#overlay').fadeOut(100,
				        			function(){
				        		$("#errormessage").hide();
				        	});
				        });
				        
				        $('.applMessCancel').click(function(){
				        	$('#overlay').fadeOut(100,
				        			function(){
				        		$("#applymessage").hide();
				        	});
				        });
				        
				        $('.applMessApply').click(function(){
				        	$("#loader") 
				        		.css("display", "block") // убирaем у мoдaльнoгo oкнa display: none;
				        		.animate({opacity: 1, top: "50%"}, 200); // плaвнo прибaвляем прoзрaчнoсть oднoвременнo сo съезжaнием вниз
				        	$('#applymessage').hide();
				        });
				        
				        $('.accMessOk').click(function(){
				        	$('#overlay').fadeOut(100,
				        			function(){
				        		$("#accessmessage").hide();
				        	});
					    	$(".textR").html("");
				        });
				     	 
				    });
			    </script>
			</div>
		</div>
	</body>
</html>