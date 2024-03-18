package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");        // 안하면 한글 깨짐
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			PrintWriter out=response.getWriter();
			out.println("<b>아이디는 "+id);
			out.println("<b>암호는 "+pw);
			
			System.out.println("id:" + id);
			System.out.println("pw:" + pw);
			
			HttpSession session=request.getSession();
			session.setAttribute("id","고양이");
			session.setMaxInactiveInterval(60);
			
		}

}
