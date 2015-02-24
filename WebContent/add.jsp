<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
//request.setCharacterEncoding("UTF-8");
String _x=request.getParameter("x");
String _y=request.getParameter("y");

int x=0;
int y=0;
int sum=0;

if(_x !=null && !_x.equals(""))
	x=Integer.parseInt(_x);

if(_y !=null && !_y.equals(""))
	y=Integer.parseInt(_y);	

/*		if(request.getMethod().equals("POST"))
{
	x=Integer.parseInt(request.getParameter("x"));
	y=Integer.parseInt(request.getParameter("y"));
}*/

sum = x+y;
String _save = request.getParameter("save");

if(_save != null){
	String _sum = request.getParameter("sum");
	//_save=new String(_save.getBytes("ISO-8859-1"),"UTF-8");
	System.out.println("saved in app");
	
	if(_save.equals("app")){
		//ServletContext application = request.getServletContext();
		application.setAttribute("sum", _sum);
		System.out.println("saved in app");
	}
	else if(_save.equals("session")){
		//HttpSession session = request.getSession();
		session.setAttribute("sum", _sum);
		System.out.println("saved in session");
	}
	else if(_save.equals("cookie")){
		Cookie cookie = new Cookie("sum", _sum);
		cookie.setMaxAge(24*60*60);//24시간
		response.addCookie(cookie);
		System.out.println("saved in cookie");
	}
}

//PrintWriter out = response.getWriter();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add.jsp" method="post">
		<ul>
			<li><label for = "x">X</label><input name="x"/></li>
			<li><label for = "y">Y</label><input name="y"/></li>
			<li><label for = "sum">SUM:</label><input name="sum" value="<%=sum%>"/></li>
		</ul>
		<p><input type="submit"name="add"value="덧셈"/></p>
		<p><input type="submit"name="save"value="앱"/></p>
		<p><input type="submit"name="save"value="세션"/></p>
		<p><input type="submit"name="save"value="쿠키"/></p>
		<a href = "index">home</a>
	</form>
</body>
</html>