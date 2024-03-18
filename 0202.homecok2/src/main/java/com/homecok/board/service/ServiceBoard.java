package com.homecok.board.service;

import com.homecok.board.BoardListProcessor;
import com.homecok.dao.DaoBoard;
import com.homecok.dto.Dto;

//서비스 코드가 이전보다 단순해짐
public class ServiceBoard {
	DaoBoard dao;

	public ServiceBoard() {
		dao = new DaoBoard();
	}
	public void del(String category, String no) {
		dao.del(category, no);
	}
	public void write(Dto d) {
		dao.insert(d);
	}
	public Dto read(String category, String no) {
		return dao.selectPost(category, no);
	}
	public BoardListProcessor list(String category, String currentPage, String word) {
		if(currentPage==null) {
			currentPage="1";
		}
		BoardListProcessor blp=new BoardListProcessor(dao,category, currentPage, word);
		return blp;
	}
	public void edit(Dto d, String no) {
		dao.update(d, no);
	}
}
