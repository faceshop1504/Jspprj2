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
 		
 		function init()
 		{
 			var btnSum=document.getElementById("btn-sum");
 			btnSum.onclick=btnSumClick;
 		}
 		function btnSumClick()
 		{
 			var txtX=document.getElementById("txt-x");
 			var txtY=document.getElementById("txt-y");
 			var txtSum=document.getElementById("txt-sum");
 			 x = parseInt(txtX.value);
 			 y = parseInt(txtY.value);
 			txtSum.value=x+y;
 		}
 		window.onload=init;