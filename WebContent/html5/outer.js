function openDoc(){
	//window.location.href="http://www.newlecture.com";
	window.frames[0].location.href="http://www.daum.net";
}


function init()
	{
		var btnOpenDoc = document.getElementById("btn-stn");
		btnOpenDoc.onclick=openDoc;
	
	}
	
	window.onload=init;