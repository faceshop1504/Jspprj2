package ksh;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index")
public class index extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		// out.println(result);

		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		String _sum = "0";
		String _app = "0";
		String _session = "0";
		String _cookie = "";

		if (application.getAttribute("sum") != null)
			_app = application.getAttribute("sum").toString();

		if (session.getAttribute("sum") != null)
			_session = session.getAttribute("sum").toString();

		Cookie[] cookies = request.getCookies();

		if (cookies != null)
			for (Cookie cookie : cookies)
				if ("sum".equals(cookie.getName()))
					_cookie = cookie.getValue();

		/*
		 * if(cookie.getAttribute("sum") != null) _cookie =
		 * cookie.getAttribute("sum").toString();
		 */

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<p><a href=\"add\"> 계산하기</a></p>");
		out.write("<p> 마지막 계산한값 app: <input value=\"" + _app + "\"/>");
		out.write("<p> 마지막 계산한값 session: <input value=\"" + _session + "\"/>");
		out.write("<p> 마지막 계산한값 cookie: <input value=\"" + _cookie + "\"/>");
		// out.write ("<input type=\"submit\" value=\"덧셈\"/>");
		// out.write ("<input type=\"submit\" name=\"save\" value=\"저장\"/>");
		// out.write ("<p><input type=\"submit\"value=\"덧셈\"/></p>");
		out.write("</body>");
		out.write("</html>");

	}
}
