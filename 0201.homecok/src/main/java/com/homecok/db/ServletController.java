package com.homecok.db;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homecok.util.Cw;

@WebServlet("/board/*")
public class ServletController extends HttpServlet {
	String nextPage;
	Dao dao;
	Service service;

	public void init() throws ServletException {
		dao = new Dao();
		service = new Service();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		Cw.wn("action:" + action);
		if (action != null) {
			switch (action) {
			case "/del":
				nextPage = "/board/list";
				service.del(request.getParameter("no"));
				break;
			case "/write":
				nextPage = "/board/list";
				Dto dto = new Dto(request.getParameter("title"), request.getParameter("id"),
						request.getParameter("text"));
				service.write(dto);
				break;
			case "/edit_insert":// todo
				Cw.wn("수정-insert");
				nextPage = "/edit.jsp";
//			request.setAttribute("post", dao.read(request.getParameter("no")));	//🐇서비스🐇:수정 기능					
				request.setAttribute("post", service.read(request.getParameter("no"))); // 🐇서비스🐇:수정 기능
				break;

			case "/edit_proc":
				Cw.wn("수정");
				nextPage = "/board/list";
				service.edit(new Dto(request.getParameter("title"), request.getParameter("text")),
						request.getParameter("no"));
				break;

			case "/read":
				nextPage = "/read.jsp";
				Dto d = service.read(request.getParameter("no"));
				request.setAttribute("post", d);
				break;
			case "/list":
				nextPage = "/list.jsp";
				ArrayList<Dto> posts = service.list();
				request.setAttribute("posts", posts);
				break;
			}
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request, response);
		}

	}
}