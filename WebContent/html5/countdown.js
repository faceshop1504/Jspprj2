/**
 * 
 */
/*function printResult()
 		{
 			var x,y;
 			var btnPrint=document.getElementById("btn-print");
 			x=prompt("x값 넣어봐", 0);
 			y=prompt("y값 넣어봐", 0);
 			x=parseInt(x);
 			y=parseInt(y);
 			//alert(x+y);
 			btnPrint.value=x+y;
 			
 			
 		}
 		
 		function init()
 		{
 			var btnPrint=document.getElementById("btn-print");
 			btnPrint.onclick=printResult;
 		}
 		
 		window.onload = init;*/
		var count=60;
		var timer=null;
 		function countDown()
 		{
 			var lblCount = document.getElementById("lbl-count");
 			lblCount.innerText= --count;
 			
 			if(count>0)
 			setTimeout(countDown, 1000);
 		}
 		
 		function btnCountdownClick()
 		{
 			/*var txtX=document.getElementById("txt-x");
 			var txtY=document.getElementById("txt-y");
 			var txtSum=document.getElementById("txt-sum");
 			var x = parseInt(txtX.value);
 			var y = parseInt(txtY.value);
 			txtSum.value=txtX+txtY;*/
 			
 			//setTimeout(countDown, 1000);
 			//setInterval(countDown, 1000);
 			if(timer==null)
 				timer=setTimeout(countDown, 5000);
 		}
 		function init()
 		{
 			var btnCounDown = document.getElementById("btn-countdown");
 			btnCounDown.onclick=btnCountdownClick;
 			
 		}
 		
 		window.onload=init;        //초기진행!