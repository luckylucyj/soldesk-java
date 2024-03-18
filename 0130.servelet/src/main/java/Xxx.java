import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Xxx extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		System.out.println("아이디: "+id);
		System.out.println("암호: "+pw);
		}
}
