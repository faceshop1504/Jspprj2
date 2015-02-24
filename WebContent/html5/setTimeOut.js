/**
 * 
 */

 		function countdown(){
 			alert("hello");
}



 		function init(){
 			var btnCountdown=document.getElementById("btn-countdown"); //변수선언 및  btn-countdown사용 
 			btnCountdown.onclick=countdown;
}

 		window.onload=init;