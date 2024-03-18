package com.homecok.board;

import java.util.ArrayList;

import com.homecok.dao.DaoBoard;
import com.homecok.dto.Dto;

public class BoardListProcessor {

	//daoBoard가 뭘까?
	private DaoBoard dao;
	public String category;
	public ArrayList<Dto>posts;
	//전체 페이지수
	public int totalPage=0;
	//현재 페이지수
	public int currentPage=0;
	//검색어
	public String word;
	
	
	int totalBlock=0;
	int currentBlockNo=0;
	int blockStartNo=0;
	int blockEndNo=0;
	
	int prevPage=0;
	int nextPage=0;
	
	boolean hasPrev=true;
	boolean hasNext=true;
	
	public BoardListProcessor(DaoBoard dao, String category, String currentPage, String word) {
		super();
		this.dao=dao;
		this.category=category;
		this.currentPage=Integer.parseInt(currentPage);
		this.word=word;
		if(word==null) {
			this.totalPage=getPageCount();
			getList();
		}else {
			this.totalPage=getPageCount(word);
			getList(word);
		}
		
		totalBlock=(int)Math.ceil((double)totalPage/Board.PAGE_LINK_AMOUNT);
		currentBlockNo=(int)Math.ceil((double)this.currentPage/Board.PAGE_LINK_AMOUNT);
		blockStartNo=(currentBlockNo-1)*Board.PAGE_LINK_AMOUNT+1;
		blockEndNo=currentBlockNo*Board.PAGE_LINK_AMOUNT;
		if(blockEndNo>totalPage) {
			blockEndNo=totalPage;
		}
		
		if(currentBlockNo==1) {
			hasPrev=false;
		}else {
			hasPrev=true;
			prevPage=(currentBlockNo-1)*Board.PAGE_LINK_AMOUNT;
		}
		
		if(currentBlockNo<totalBlock) {
			hasNext=true;
			nextPage=currentBlockNo*Board.PAGE_LINK_AMOUNT+1;
		}else {
			hasNext=false;
		}
	
	}
	public void getList() {
		int startIndex=(currentPage-1)*Board.LIST_AMOUNT;
		posts=dao.selectList(category, startIndex);
	}
	
	public void getList(String word) {
		int startIndex=(currentPage-1)*Board.LIST_AMOUNT;
		posts=dao.selectList(category, startIndex,word);
	}
	
	public int getPageCount() {
		int totalPageCount=0;
		int count=dao.selectPostCount(category);
		if(count%Board.LIST_AMOUNT==0) {
			totalPageCount=count/Board.LIST_AMOUNT;
		}else {
			totalPageCount=count/Board.LIST_AMOUNT+1;
		}
		return totalPageCount;
	}
	
	public int getPageCount(String word) {
		int totalPageCount=0;
		int count=dao.selectSearchPostCount(category,word);
		if(count%Board.LIST_AMOUNT==0) {
			totalPageCount=count/Board.LIST_AMOUNT;
		}else {
			totalPageCount=count/Board.LIST_AMOUNT+1;
		}
		return totalPageCount;
	}
	
	//글 리스트 객체 얻는 함수
	public ArrayList<Dto>getPosts(){
		return posts;
	}
	
	public String getHtmlPageList() {
		String html="";
		if(hasPrev) {
			if(word==null) {
				html=html+String.format("<a href='/board/list?category=%s&page=%d'>이전블럭가기</a>",category,prevPage);
			}else {
				html=html+String.format("<a href='/board/list?category=%s&page=%d&word=%s'>이전블럭가기</a>",category,prevPage,word);
			}
		}
		
		for(int i=blockStartNo;i<=blockEndNo;i++) {
			if(word==null) {
				html=html+String.format("<a href='/board/list?category=%s&page=%d'>%d</a>&nbsp;&nbsp;",category,i,i);
			}else {
				html=html+String.format("<a href='/board/list?category=%s&page=%d&word=%s'>%d</a>&nbsp;&nbsp;",category,i,word,i);
			}
		}
		
		if(hasNext) {
			if(word==null) {
				html=html+String.format("<a href='/board/list?category=%s&page=%d'>다음블럭가기</a>",category,nextPage);
			}else {
				html=html+String.format("<a href='/board/list?category=%s&page=%d&word=%s'>다음블럭가기</a>",category,nextPage,word);
			}
		}
		
		return html;
	}
}
