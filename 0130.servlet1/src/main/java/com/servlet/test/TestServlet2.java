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
 * Servlet implementation class TestServlet2
 */
@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("==== 두 겟");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");	// 안하면 한글 깨짐
		
		
		if(id.equals("cat")&&pw.equals("1234")) {
			HttpSession session = req.getSession();
			session.setAttribute("idKey", id);
			session.setMaxInactiveInterval(30);
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<a href='index2.jsp'>인덱스2</a>");
		
		
//		resp.sendRedirect("http://daum.net");
	}
	

	@Override
	public void init() throws ServletException {
		System.out.println("이닛");
	}
	
	@Override
	public void destroy() {
		System.out.println("==== 디스트로이");
	}

}
