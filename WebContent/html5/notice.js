		              //새로운 win   참조는 접근하는것이다!
 		function btnResizeClick()
 		{
 			opener.resizeTo(100, 100);
 			
 			
 		}
 		function btnMoveClick()
 		{
 			opener.moveTo(200, 200);//win=open("notice.html", "_blank", "width=500px", "height=400px");
 			//alert("!!!");
 			
 		}
 		function btnOpenerCloseClick()
 		{
 			opener.close();
 			
 			
 		}
 		function init()
 		{
 			var btnResize = document.getElementById("btn-resize");
 			var btnMove = document.getElementById("btn-move");
 			var btnOpenerClose = document.getElementById("btn-opener-close");
 			btnResize.onclick=btnResizeClick;
 			btnMove.onclick=btnMoveClick;
 			btnOpenerClose.onclick=btnOpenerCloseClick;
 		
 		}
 		
 		window.onload=init;