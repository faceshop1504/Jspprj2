<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="ksh.jspprj.dao.jdbc.JdbcNoticeDao"%>
<%@page import="ksh.jspprj.dao.NoticeDao"%>
<%@page import="ksh.jspprj.model.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ServletContext ctx = request.getServletContext();
	String path = ctx.getRealPath("/cutomer/upload");
	out.println(path + "<br />");
	
	MultipartRequest req=new MultipartRequest(request
						, path
						, 1024*1024*10
						, "UTF-8"
						, new DefaultFileRenamePolicy());
	
	String title = req.getParameter("title");
   	String file = req.getFilesystemName("file");
   	String content = req.getParameter("content");
   	out.println(path + "<br />");
   	out.println(path + "<br />");
   	out.println(path + "<br />");
	
  /*String title = request.getParameter("title");
   	String file = request.getParameter("file");
   	String content = request.getParameter("content");*/
  	 
   	Notice n = new Notice();
   	n.setTitle(title);
   	n.setCode(file);
   	n.setContent(content);
   	n.setWriter("SungWan");
   	
   	NoticeDao dao = new JdbcNoticeDao();
   	dao.insert(n);
  	 
   	response.sendRedirect("notice.jsp");
%>