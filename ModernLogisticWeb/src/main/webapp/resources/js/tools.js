/**
 * @author Rosteach
 */

$(document).ready(function(){
    /* start */
    $(".back img").hover(
        function(){
	       $(this).stop().animate({width: "35px", height:"35px"});
        }
        ,             
        function(){
            $(this).stop().animate({width: "30px", height:"30px"});
        }
    );
    $(".info img").hover(
            function(){
    	       $(this).stop().animate({width: "35px", height:"35px"});
            }
            ,             
            function(){
                $(this).stop().animate({width: "30px", height:"30px"});
            }
        );
    /* end */
    /* start .item:first */
    $(".item:first").hover(
        function(){
	       $(this).css("background","#ADD8E6");
        }
        ,             
        function(){
            $(this).css("background","silver");
        }
    );
    /* end */
    /* start .item:second */
    $(".item:eq(1)").hover(
        function(){
	       $(this).css("background","#B0EBB6");
        }
        ,             
        function(){
            $(this).css("background","silver");
        }
    );
    /* end */
    $(".item:eq(2)").hover(
        function(){
            $(this).css("background","#FCD97E");
        }
        ,             
        function(){
            $(this).css("background","silver");
        }
    );
});