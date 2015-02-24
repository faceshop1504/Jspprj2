
		
		var win = null;               //새로운 win   참조는 접근하는것이다!
 		function btnNewTabClick()
 		{
 			win=open("http://www.naver.com", "_blank");
 			//alert("!!!");
 			
 		}
 		function btnNewWinClick()
 		{
 			win=open("notice.html", "_blank", "width=500px", "height=400px");
 			//alert("!!!");
 			
 		}
 		function btnCloseWinClick()
 		{
 			wind.close();
 			//alert("!!!");
 			
 		}
 		function init()
 		{
 			var btnNewTab = document.getElementById("btn-new-tab");
 			var btnNewWin = document.getElementById("btn-new-win");
 			var btnCloseWin = document.getElementById("btn-close-win");
 			btnNewTab.onclick=btnNewTabClick;
 			btnNewWin.onclick=btnNewWinClick;
 			btnCloseWin.onclick=btnCloseWinClick;
 			
 		}
 		
 		window.onload=init;