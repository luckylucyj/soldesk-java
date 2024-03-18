package com.homecok.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homecok.board.BoardListProcessor;
import com.homecok.board.service.ServiceBoard;
import com.homecok.dto.Dto;
import com.homecok.util.Cw;

@WebServlet("/board/*")
public class ControllerBoard extends HttpServlet {
	String category;
	String nextPage;
	ServiceBoard service;
	
	//init 초기화 ->서비스를
	public void init()throws ServletException{
		service=new ServiceBoard();
	}
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		category=request.getParameter("category");
		String action=request.getPathInfo();
		Cw.wn("action"+action);
		if(action!=null) {
			switch(action) {
			case "/del":
				nextPage="/board/list";
				service.del(category, request.getParameter("no"));
				break;
				case "/write":
					nextPage="/board/list";
					Dto dto=new Dto(
							category,
							request.getParameter("title"),
							request.getParameter("text"),
							request.getParameter("id")
							);
					service.write(dto);
					break;
					//수정한 걸 집어 넣기
				case "/edit_insert":
					Cw.wn("수정-insert");
					nextPage="/edit.jsp";
					request.setAttribute("post", service.read(category, request.getParameter("no")));
					break;
				case "/edit_proc":
			Cw.wn("수정-proc");
			nextPage="/board/list";
			service.edit(new Dto(request.getParameter("title"),
					request.getParameter("text")),request.getParameter("no"));
			break;
				case "/read":
					nextPage="/read.jsp";
					Dto d=service.read(category,request.getParameter("no"));
					request.setAttribute("post",d);
					break;
					
				case "/list":
					nextPage="/list.jsp";
					BoardListProcessor blp=service.list(category, request.getParameter("page"),request.getParameter("word"));
					request.setAttribute("blp", blp);
					break;
			}
			RequestDispatcher d=request.getRequestDispatcher(nextPage);
			d.forward(request,response);
		}
	}

}
