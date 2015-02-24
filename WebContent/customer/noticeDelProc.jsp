<%@page import="ksh.jspprj.dao.jdbc.JdbcNoticeDao"%>
<%@page import="ksh.jspprj.dao.NoticeDao"%>
<%@page import="ksh.jspprj.model.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   String code = request.getParameter("c");
   
   Notice n = new Notice();
   
   NoticeDao dao = new JdbcNoticeDao();
   dao.delete(code);
   
   response.sendRedirect("notice.jsp");
%>