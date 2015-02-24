/*function init(){
 
} 이런식으로 사용하지 않고 addEventListener 넣어서 밑에처럼 사용

window.addEventListener("load", init);*/
window.addEventListener("load", function(){  //이벤트함수를 추가한다!
 /*var pic1=document.getElementById("gallery-pic1");
 var pic2=document.getElementById("gallery-pic2");
 var pic3=document.getElementById("gallery-pic3");
 
 pic1.onclick=picClick;
 pic2.onclick=picClick;
 pic3.onclick=picClick;*/
 
 //pic1=document.getElementById("gallery-pic1");
 //var pics=document.getElementById("gallery-pic-list"); //getElementById를 밑에처럼 querySelector로 바꿔줌
 
 console.log("hello");
 
 pic1=document.querySelector("#gallery-pic1");
 var target=document.querySelector("#gallery-pic-list");
 /*pic1.onclick=picClick;
 pics.onclick=picClick;*/
 
 pic1.addEventListener("click", picClick, true);
 target.addEventListener("click", picClick, true);
 
 var preBtn=document.querySelector(".gallery-prev-button");
 var nextBtn=document.querySelector(".gallery-next-button");
 
 //pics.style.left="0px";
 target.style.left="0px";
 
 preBtn.addEventListener("click", function(){
  //alert("prev");
  /*var from = parseInt(pics.style.left);
  var to = from - 120;
  
  var id = setInterval(function(){
   //애니메이션을 위한 프레임 연산
   
   from-=1;
   
   if(from < to)
    clearInterval(id)
   
   pics.style.left = from+"px"; 
    
  }, 10);
  //pics.style.left = "-120px"; */
  
  //animateBy(target, "left","-120px", 2000, aa) //(target, property, to, duration)
  animateTo(target, "left","-120px", 2000, aa)
 });
 
 nextBtn.addEventListener("click", function(){
  /*var from = parseInt(pics.style.left);
  var to = from + 120;
  
  var id = setInterval(function(){
   
   from+=1;
   
   if(from > to)
    clearInterval(id)
   
   pics.style.left = from+"px";
  }, 10);
  //pics.style.left = "120px"; */ 
  //animateBy(target, "left", "120px", 3000, linear)
  animateTo(target, "left", "120px", 3000, linear)
 });
 
 var fileButton=document.querySelector("#file-button");
 fileButton.addEventListener("click", function(){
  //var event = new MouseEvent("click",{ //크롬에서 실행할때
   var event = document.createEvent("MouseEvent"); //익스플로어에서 실행방법(옛날방법임)
   event.initEvent("click", true, true);
   /*'view':window, //크롬에서 실행시 필요함
   'bubbles':true,
   'cancelable':true
  });*/
  var file=document.querySelector("#gallery-file");
  file.dispatchEvent(event);
 });
 
 /*pic1.onclick=function(){
  var img1=document.createElement("img");
  img1.src="pic1.jpg";
  
  var box=document.getElementById("gallery-show-box");
  
  //박스를 비워주자
  while(box.firstChild)
   box.removeChild(box.firstChild);
  
  box.appendChild(img1);
 }
 
 pic2.onclick=function(){
  var img1=document.createElement("img");
  img1.src="pic2.jpg";
  
  var box=document.getElementById("gallery-show-box");
  
  //박스를 비워주자
  while(box.firstChild)
   box.removeChild(box.firstChild);
  
  box.appendChild(img1);
 }
 
 pic3.onclick=function(){
  var img1=document.createElement("img");
  img1.src="pic3.jpg";
  
  var box=document.getElementById("gallery-show-box");
  
  //박스를 비워주자
  while(box.firstChild)
   box.removeChild(box.firstChild);
  
  box.appendChild(img1);
 }*/
 
});

function picClick(){
 if(event.target.tagName != "IMG")return;
 
 event.stopPropagation(); //버블링 방지를 막아줌?
 event.preventDefault(); //얘를입력해주면 a태그로 달아놓은 사이트로 이동하지 않고 디폴트상태로 있는다.
 
 var img=document.createElement("img");
 img.src=event.target.src;
 img.style.height = "50px";
 
 img.addEventListener("show",function(e){
  alert("show show SHOW");
  alert(e.detail);
 });
 
 //var box=document.getElementById("gallery-show-box");
 var box=document.querySelector("#gallery-show-box");
 
 //박스를 비워주자
 var last;
 while(last = box.firstChild)
  box.removeChild(box.firstChild);
 
 box.appendChild(img);
 
 //animateBy(img, "height", "250px", 1000, linear);
 animateTo(img, "height", "250px", 1000, linear);
}
//↓어떤녀석을 어떻게 얼마의 시간후에 어덯게 해라! 이런뜻?
function animateBy(target, property, to, duration, easing, callback){  //리펙토링을 사용을 위해 move 함수를 생성해주었음(move함수 실행을 위해 pics를 target로 바꿔줌)
 if(target.style[property] == "")
  target.style[property] = "0px";
 
 var from = parseInt(target.style[property]);
 var to = parseInt(to);
 to = to + from;
 var start = new Date;
 
 
 var id = setInterval(function(){
  /*from += 1*(to<from ? -1:1);
  
  if(from == to){
   clearInterval(id);
   target.style[property] = to +"px";
   return;
  }
  target.style[property] = from + "px";*/

   var timePassed = new Date - start;
   var progress = timePassed / duration;
   
   if(progress>1) progress = 1;
   if(easing)target.style[property] = (from + (to - from)*easing(progress)) + "px";
   else target.style[property] = (from +(to-from)*progress) + "px";
   
   if(progress ==1) clearInterval(id);
   
   if(callback)
    callbakc();
   
   
  }, 10);  
 }

function aa(p){
 return Math.pow(p,4);
}

function linear(progress){
 return progress;
}

function animateTo(target, property, to, duration, easing, callback){  //리펙토링을 사용을 위해 move 함수를 생성해주었음(move함수 실행을 위해 pics를 target로 바꿔줌)
 if(target.style[property] == "")
  target.style[property] = "0px";
 
 var from = parseInt(target.style[property]);
 var to = parseInt(to);
 //to = to + from;
 var start = new Date;
 
 
 var id = setInterval(function(){
  /*from += 1*(to<from ? -1:1);
  
  if(from == to){
   clearInterval(id);
   target.style[property] = to +"px";
   return;
  }
  target.style[property] = from + "px";*/

   var timePassed = new Date - start;
   var progress = timePassed / duration;
   
   if(progress>1) progress = 1;
   if(easing)target.style[property] = (from + (to - from)*easing(progress)) + "px";
   else target.style[property] = (from +(to-from)*progress) + "px";
   
   if(progress ==1) clearInterval(id);
   
   if(callback)
    callbakc();
   
   
  }, 10);  
 }
