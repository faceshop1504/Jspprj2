<%@page import="ksh.jspprj.dao.MemberDao"%>
<%@page import="ksh.jspprj.dao.jdbc.JdbcMemberDao"%>
<%@page import="ksh.jspprj.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	String uid = request.getParameter("uid");
	String pwd = request.getParameter("pwd");
	

	Member m = new JdbcMemberDao().getMember(uid);

	String msg=null;
	
	if(m == null)
		msg="몰라 알수가없어!";
	else if(!m.getPwd().equals(pwd))
		msg="이힝";
	
	else
	{
		session.setAttribute("uid", uid);
	}
	if(msg!=null)// 오류검사
	{
		request.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("login.jsp"); //로그인 화면으로 돌아간다.
	
		dispatcher.forward(request, response);  //단 forward를 사용하여 Proc의 정보를 가지고 돌아간다.
	}
	
	response.sendRedirect("../index.jsp");   //오류가 없을시 초기 페이지로 넘어간다.
	%>
	
	<%= msg %>
	