
function printResult()
 		{
 			var x,y;
 			var btnPrint=document.getElementById("btn-print");
 			var result=document.getElementById("result");
 			x=prompt("x값 넣어봐", 0);
 			y=prompt("y값 넣어봐", 0);
 			x=parseInt(x);
 			y=parseInt(y);
 			//alert(x+y);
 			btnPrint.value=x+y;
 			result.value=btnPrint.value;
 			//alert(btnPrint.value);
 			
 		}
 		
 		function init()
 		{
 			var btnPrint=document.getElementById("btn-print");
 			
 			btnPrint.onclick=printResult;
 			
 		}
 		
 		window.onload = init;