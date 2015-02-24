<%@page import="ksh.jspprj.dao.jdbc.JdbcNoticeDao"%>
<%@page import="ksh.jspprj.dao.NoticeDao"%>
<%@page import="ksh.jspprj.model.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   String title = request.getParameter("title");
   String file = request.getParameter("file");
   String content = request.getParameter("content");
   
   Notice n = new Notice();
   n.setTitle(title);
   n.setContent(content);
   n.setWriter("SungWan");
   
   NoticeDao dao = new JdbcNoticeDao();
   dao.insert(n);
   
   response.sendRedirect("notice.jsp");
%>